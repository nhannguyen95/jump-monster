package com.badlogic.gdx.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;

public final class StreamUtils {
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final byte[] EMPTY_BYTES = new byte[0];

    public static class OptimizedByteArrayOutputStream extends ByteArrayOutputStream {
        public OptimizedByteArrayOutputStream(int initialSize) {
            super(initialSize);
        }

        public synchronized byte[] toByteArray() {
            byte[] bArr;
            if (this.count == this.buf.length) {
                bArr = this.buf;
            } else {
                bArr = super.toByteArray();
            }
            return bArr;
        }

        public byte[] getBuffer() {
            return this.buf;
        }
    }

    public static void copyStream(InputStream input, OutputStream output) throws IOException {
        copyStream(input, output, 8192);
    }

    public static void copyStream(InputStream input, OutputStream output, int bufferSize) throws IOException {
        byte[] buffer = new byte[bufferSize];
        while (true) {
            int bytesRead = input.read(buffer);
            if (bytesRead != -1) {
                output.write(buffer, 0, bytesRead);
            } else {
                return;
            }
        }
    }

    public static byte[] copyStreamToByteArray(InputStream input) throws IOException {
        return copyStreamToByteArray(input, input.available());
    }

    public static byte[] copyStreamToByteArray(InputStream input, int estimatedSize) throws IOException {
        ByteArrayOutputStream baos = new OptimizedByteArrayOutputStream(Math.max(0, estimatedSize));
        copyStream(input, baos);
        return baos.toByteArray();
    }

    public static String copyStreamToString(InputStream input) throws IOException {
        return copyStreamToString(input, input.available());
    }

    public static String copyStreamToString(InputStream input, int approxStringLength) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringWriter w = new StringWriter(Math.max(0, approxStringLength));
        char[] buffer = new char[8192];
        while (true) {
            int charsRead = reader.read(buffer);
            if (charsRead == -1) {
                return w.toString();
            }
            w.write(buffer, 0, charsRead);
        }
    }

    public static void closeQuietly(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (Exception e) {
            }
        }
    }
}
