package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class dp {
    private static final ThreadFactory ra = new C02452();
    private static final ThreadPoolExecutor rb = new ThreadPoolExecutor(0, 10, 65, TimeUnit.SECONDS, new SynchronousQueue(true), ra);

    /* renamed from: com.google.android.gms.internal.dp$2 */
    static class C02452 implements ThreadFactory {
        private final AtomicInteger rd = new AtomicInteger(1);

        C02452() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AdWorker #" + this.rd.getAndIncrement());
        }
    }

    public static void execute(final Runnable task) {
        try {
            rb.execute(new Runnable() {
                public void run() {
                    Process.setThreadPriority(10);
                    task.run();
                }
            });
        } catch (Throwable e) {
            dw.m818c("Too many background threads already running. Aborting task.  Current pool size: " + getPoolSize(), e);
        }
    }

    public static int getPoolSize() {
        return rb.getPoolSize();
    }
}
