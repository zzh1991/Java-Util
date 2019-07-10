package util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author zhihao zhang
 * @date 2019-07-10
 */

class EncryptUtilTest {
    private static final String text = "encrypt and decrypt test";
    private static final String password = "password";
    private static final String encryptText = "178DFD94E7F50276E95C25BEDFEBB794E4BE7DE164AB50C355427CA444B50144";

    @Test
    void encrypt() {
        assertThat(EncryptUtil.encrypt(text, password))
                .isEqualTo(encryptText);
    }

    @Test
    void decrypt() {
        assertThat(EncryptUtil.decrypt(encryptText, password))
                .isEqualTo(text);
    }
}