package com.zzh.util.util;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import lombok.experimental.UtilityClass;

/**
 * @author zhihao zhang
 * @since 9/19/20
 */

@UtilityClass
public class BloomFilterUtil {
    public static <T> BloomFilter<T> generateBloomFilter(Funnel<? super T> funnel,
                                                         long expectedNumber, double falsePositionPercent) {
        return BloomFilter.create(funnel, expectedNumber, falsePositionPercent);
    }

    public static BloomFilter<Integer> generateBloomIntegerFilter(long expectedNumber, double falsePositionPercent) {
        return BloomFilter.create(Funnels.integerFunnel(), expectedNumber, falsePositionPercent);
    }
}
