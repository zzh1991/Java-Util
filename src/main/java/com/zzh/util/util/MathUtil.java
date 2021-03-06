package com.zzh.util.util;

import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @author zhihao zhang
 * @since 2020.03.22
 */

public class MathUtil {
    public double average(int[] array) {
        if (Objects.isNull(array) || array.length == 0) {
            return 0;
        }
        return IntStream.of(array)
                .average()
                .orElse(0);
    }
}
