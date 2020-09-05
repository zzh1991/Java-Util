package com.zzh.util.util;

import java.util.List;

/**
 * @author zhihao zhang
 * @since 8/7/20
 */

public class HashCodeUtil {
    public static int getHashCode(Object object) {
        return object.hashCode();
    }

    public static int getIdentityHashCode(Object object) {
        return System.identityHashCode(object);
    }

    public static int calculateListHashCode(List<?> list) {
        int hashCode = 1;
        for (Object e: list) {
            if (e == null) {
                continue;
            }
            hashCode = 31 * hashCode + e.hashCode();
        }
        return hashCode;
    }
}
