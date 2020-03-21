package com.zzh.util.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author zhihao zhang
 * @since 2019-07-10
 */

class ByteHexUtilTest {
    private static final String HEX_STRING = "4279746520616E64204865782054657374";
    private static final byte[] bytes = "Byte and Hex Test".getBytes();

    @Test
    void bytesToHexString() {
        assertThat(ByteHexUtil.bytesToHexString(bytes))
                .isEqualTo(HEX_STRING);
    }

    @Test
    void hexStringToBytes() {
        assertThat(ByteHexUtil.hexStringToBytes(HEX_STRING))
                .isEqualTo(bytes);
    }
}