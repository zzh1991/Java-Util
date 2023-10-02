package com.zzh.util.util;

import org.junit.jupiter.api.Test;
class ThreadUtilTest {

    @Test
    void ofVirtualThread() throws InterruptedException {
        Thread thread = ThreadUtil.ofVirtualThread("test-thread", () -> {
            System.out.println("Thread t name: " +  Thread.currentThread().getName());
        });
        thread.join();
    }
}