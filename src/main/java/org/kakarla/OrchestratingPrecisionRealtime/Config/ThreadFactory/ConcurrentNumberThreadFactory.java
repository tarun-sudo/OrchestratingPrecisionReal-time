package org.kakarla.OrchestratingPrecisionRealtime.Config.ThreadFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


public class ConcurrentNumberThreadFactory implements ThreadFactory {

    private final String baseName;
    private final AtomicInteger counter = new AtomicInteger(0);

    public ConcurrentNumberThreadFactory(String baseName) {
        this.baseName = baseName;
    }

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(r +  baseName + "-thread-" + counter.incrementAndGet());
        return new Thread(r, baseName + "-thread-" + counter.incrementAndGet());
    }
}
