package com.zzh.util.util;

import com.google.common.io.BaseEncoding;

/**
 * @author zhihao zhang
 * @since 2019-07-10
 */

public final class ByteHexUtil {
    private ByteHexUtil() {}

    public static String bytesToHexString(byte[] bytes) {
        return BaseEncoding.base16().encode(bytes);
    }

    public static byte[] hexStringToBytes(String hexString) {
        return BaseEncoding.base16()
                .decode(hexString.toUpperCase());
    }
}
