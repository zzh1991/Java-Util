package com.zzh.util.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HashUtilTest {

    @Test
    void hash32FromLong() {
        long num = 100L;
        int result = 635063951;
        int hash = HashUtil.hash32(num);
        assertThat(hash).isEqualTo(result);
    }

    @Test
    void hash32FromString() {
        String text = "https://blog.zzhpro.com";
        int result = 267637069;
        int hash = HashUtil.hash32(text);
        assertThat(hash).isEqualTo(result);
    }

    @Test
    void hash128() {
        String text = "https://blog.zzhpro.com";
        long[] hash128 = HashUtil.hash128(text);
        long[] result = new long[]{-3210188107689017308L, 3681918891195099272L};
        assertThat(hash128).isEqualTo(result);
    }

    @Test
    void base62() {
        int hash = 267637069;
        String result = "HnaggAuv4YmX";
        String s = HashUtil.base62(hash);
        assertThat(s).isEqualTo(result);

        int hash2 = Integer.MAX_VALUE;
        System.out.println(HashUtil.base62(hash2));
    }
}