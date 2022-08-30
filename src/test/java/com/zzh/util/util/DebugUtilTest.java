package com.zzh.util.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DebugUtilTest {

    /**
     * run mode, test is successful
     * debug mode, test is failed
     */
    @Test
    void isDebuggerAttached() {
        Assertions.assertThat(DebugUtil.isDebugMode()).isFalse();
    }
}