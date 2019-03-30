package com.badlogic.gdx.net;

import com.badlogic.gdx.Net.HttpMethods;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NetJavaImpl {
    final ObjectMap<HttpRequest, HttpURLConnection> connections = new ObjectMap();
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    final ObjectMap<HttpRequest, HttpResponseListener> listeners = new ObjectMap();
    final Lock lock = new ReentrantLock();

    static class HttpClientResponse implements HttpResponse {
        private HttpURLConnection connection;
        private HttpStatus status;

        public HttpClientResponse(HttpURLConnection connection) throws IOException {
            this.connection = connection;
            try {
                this.status = new HttpStatus(connection.getResponseCode());
            } catch (IOException e) {
                this.status = new HttpStatus(-1);
            }
        }

        public byte[] getResult() {
            byte[] copyStreamToByteArray;
            InputStream input = getInputStream();
            try {
                copyStreamToByteArray = StreamUtils.copyStreamToByteArray(input, this.connection.getContentLength());
            } catch (IOException e) {
                copyStreamToByteArray = StreamUtils.EMPTY_BYTES;
            } finally {
                StreamUtils.closeQuietly(input);
            }
            return copyStreamToByteArray;
        }

        public String getResultAsString() {
            String copyStreamToString;
            InputStream input = getInputStream();
            try {
                copyStreamToString = StreamUtils.copyStreamToString(input, this.connection.getContentLength());
            } catch (IOException e) {
                copyStreamToString = "";
            } finally {
                StreamUtils.closeQuietly(input);
            }
            return copyStreamToString;
        }

        public InputStream getResultAsStream() {
            return getInputStream();
        }

        public HttpStatus getStatus() {
            return this.status;
        }

        public String getHeader(String name) {
            return this.connection.getHeaderField(name);
        }

        public Map<String, List<String>> getHeaders() {
            return this.connection.getHeaderFields();
        }

        private InputStream getInputStream() {
            try {
                return this.connection.getInputStream();
            } catch (IOException e) {
                return this.connection.getErrorStream();
            }
        }
    }

    public void sendHttpRequest(HttpRequest httpRequest, HttpResponseListener httpResponseListener) {
        if (httpRequest.getUrl() == null) {
            httpResponseListener.failed(new GdxRuntimeException("can't process a HTTP request without URL set"));
            return;
        }
        try {
            URL url;
            String method = httpRequest.getMethod();
            if (method.equalsIgnoreCase(HttpMethods.GET)) {
                String queryString = "";
                String value = httpRequest.getContent();
                if (!(value == null || "".equals(value))) {
                    queryString = "?" + value;
                }
                url = new URL(httpRequest.getUrl() + queryString);
            } else {
                url = new URL(httpRequest.getUrl());
            }
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            final boolean doingOutPut = method.equalsIgnoreCase(HttpMethods.POST) || method.equalsIgnoreCase(HttpMethods.PUT);
            connection.setDoOutput(doingOutPut);
            connection.setDoInput(true);
            connection.setRequestMethod(method);
            HttpURLConnection.setFollowRedirects(httpRequest.getFollowRedirects());
            this.lock.lock();
            this.connections.put(httpRequest, connection);
            this.listeners.put(httpRequest, httpResponseListener);
            this.lock.unlock();
            for (Entry<String, String> header : httpRequest.getHeaders().entrySet()) {
                connection.addRequestProperty((String) header.getKey(), (String) header.getValue());
            }
            connection.setConnectTimeout(httpRequest.getTimeOut());
            connection.setReadTimeout(httpRequest.getTimeOut());
            final HttpRequest httpRequest2 = httpRequest;
            final HttpResponseListener httpResponseListener2 = httpResponseListener;
            this.executorService.submit(new Runnable() {
                public void run() {
                    OutputStreamWriter writer;
                    OutputStream os;
                    try {
                        if (doingOutPut) {
                            String contentAsString = httpRequest2.getContent();
                            if (contentAsString != null) {
                                writer = new OutputStreamWriter(connection.getOutputStream());
                                writer.write(contentAsString);
                                StreamUtils.closeQuietly(writer);
                            } else {
                                InputStream contentAsStream = httpRequest2.getContentStream();
                                if (contentAsStream != null) {
                                    os = connection.getOutputStream();
                                    StreamUtils.copyStream(contentAsStream, os);
                                    StreamUtils.closeQuietly(os);
                                }
                            }
                        }
                        connection.connect();
                        HttpClientResponse clientResponse = new HttpClientResponse(connection);
                        NetJavaImpl.this.lock.lock();
                        HttpResponseListener listener = (HttpResponseListener) NetJavaImpl.this.listeners.get(httpRequest2);
                        if (listener != null) {
                            listener.handleHttpResponse(clientResponse);
                            NetJavaImpl.this.listeners.remove(httpRequest2);
                        }
                        NetJavaImpl.this.connections.remove(httpRequest2);
                        connection.disconnect();
                        NetJavaImpl.this.lock.unlock();
                    } catch (Exception e) {
                        connection.disconnect();
                        NetJavaImpl.this.lock.lock();
                        try {
                            httpResponseListener2.failed(e);
                        } finally {
                            NetJavaImpl.this.connections.remove(httpRequest2);
                            NetJavaImpl.this.listeners.remove(httpRequest2);
                            NetJavaImpl.this.lock.unlock();
                        }
                    } catch (Throwable th) {
                        StreamUtils.closeQuietly(writer);
                    }
                }
            });
        } catch (Exception e) {
            this.lock.lock();
            httpResponseListener.failed(e);
        } finally {
            this.connections.remove(httpRequest);
            this.listeners.remove(httpRequest);
            this.lock.unlock();
        }
    }

    public void cancelHttpRequest(HttpRequest httpRequest) {
        try {
            this.lock.lock();
            HttpResponseListener httpResponseListener = (HttpResponseListener) this.listeners.get(httpRequest);
            if (httpResponseListener != null) {
                httpResponseListener.cancelled();
                this.connections.remove(httpRequest);
                this.listeners.remove(httpRequest);
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }
}
