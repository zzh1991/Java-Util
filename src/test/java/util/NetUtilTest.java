package util;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class NetUtilTest {

    @Test
    void getRequest() throws IOException {
        System.out.println(NetUtil.getRequest("https://api.github.com/users/zzh1991"));
    }
}