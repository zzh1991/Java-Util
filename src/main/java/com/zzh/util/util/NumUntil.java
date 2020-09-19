package com.zzh.util.util;

import lombok.experimental.UtilityClass;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author zhihao zhang
 * @since 9/19/20
 */

@UtilityClass
public class NumUntil {
    public static LongAdder getLongAdder() {
        return new LongAdder();
    }

    public static LongAccumulator getLongSumAccumulator() {
        return new LongAccumulator(Long::sum, 0L);
    }
}
