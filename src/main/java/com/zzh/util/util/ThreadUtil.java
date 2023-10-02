package com.zzh.util.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhihao zhang
 * @since 2020.03.22
 */

public class ThreadUtil {
    private static ExecutorService executorService = null;

    public static ExecutorService getExecutorService(int corePoolSize, int maximumPoolSize, int queueSize,
                                              String threadGroupName) {
        if (Objects.isNull(executorService)) {
            executorService = new ThreadPoolExecutor(
                    corePoolSize, maximumPoolSize,
                    60, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(queueSize),
                    new ThreadFactoryBuilder().setNameFormat(threadGroupName.concat("-%d")).build());
        }
        return executorService;
    }

    public static Thread ofVirtualThread(String threadName, Runnable task) {
        Thread.Builder.OfVirtual virtual = Thread.ofVirtual();
        if (StringUtils.isNotBlank(threadName)) {
            virtual = virtual.name(threadName);
        }
        return virtual.start(task);
    }
}
