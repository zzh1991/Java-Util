package util;

import org.junit.jupiter.api.Test;

class DebugutilTest {

    @Test
    void isDebuggerAttached() {
        System.out.println(DebugUtil.isDebugMode());
    }
}