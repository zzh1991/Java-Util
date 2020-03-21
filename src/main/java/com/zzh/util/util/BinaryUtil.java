package com.zzh.util.util;

/**
 * @author zhihao zhang
 * @since 12/22/19
 */

public class BinaryUtil {
    public static int getProperSize(int size) {
        return  -1 >>> Integer.numberOfLeadingZeros(size - 1);
    }
}
