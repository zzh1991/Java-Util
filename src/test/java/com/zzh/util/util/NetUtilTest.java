package com.zzh.util.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class NetUtilTest {

    @Test
    void getRequest() throws IOException {
        String request = NetUtil.getRequest("https://api.github.com/users/zzh1991");
        Assertions.assertThat(request).contains("zzh1991");
    }
}