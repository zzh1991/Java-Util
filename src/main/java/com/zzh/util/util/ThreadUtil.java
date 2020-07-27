package com.zzh.util.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhihao zhang
 * @since 2020.03.22
 */

public class ThreadUtil {
    private static ExecutorService executorService = null;

    public ExecutorService getExecutorService() {
        if (Objects.isNull(executorService)) {
            executorService = new ThreadPoolExecutor(
                    2, 4,
                    60, TimeUnit.SECONDS,
                    new LinkedBlockingQueue<>(),
                    new ThreadFactoryBuilder().setNameFormat("common-thread-%d").build());
        }
        return executorService;
    }
}
