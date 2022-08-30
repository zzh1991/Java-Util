package com.zzh.util.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryUtilTest {

    @Test
    void getProperSize() {
        assertThat(BinaryUtil.getProperSize(15)).isEqualTo(16);
        assertThat(BinaryUtil.getProperSize(16)).isEqualTo(16);
        assertThat(BinaryUtil.getProperSize(17)).isEqualTo(32);
    }
}