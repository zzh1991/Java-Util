package com.zzh.util.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.zzh.util.vo.RsaKeyPairGenerator;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

class RsaUtilTest {

    private static RsaKeyPairGenerator rsaKeyPairGenerator;
    private static final String text = "encrypt and decrypt test";
    private static final String PUBLIC_KEY = "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEAxpmLOR+2hkSiEQpmoy2+uqGbcgb6shIKaT9hg1Xz8rSDuUIOEnxITSNeUw9OyAxPzR4JNjydnjGDkmrq8AuxCIRlUV9BjmN9YsKT+rLKUh3xh5TKYUuJ8YZ0oY5AhN1DH3IPn0r5ER7ZehLjVHFxuNfFoWFag48cq3z/xc9y7PrkhA0sPv1SLw90dlhpzM8kfxPNKk8hRrynBy0487jhS92RybeO+uez84sx25gjXZTBqocg9EcVneUYGk20AtzTTHKprPQsgEdrblWhovzbXTb9IYg2K13UhBT12d4KTndoOF/V8IO5aeoEfi1WTaakk5R4RMWHTxynvTvjLKlvc1Z3YO/U3eOFNk/uc69OVRCT6juVuQ33Zld+DSLnrIxs2wdRGH62kRCO1R2G7wHL+DaOOoNK1mtbYlWqXWvYT3NP5cRkuXWBt3qmjOGiNCWbhCsrVzZLiApx+H6+tnnAKIxsCePFzSavndsnDYx2rA17MrUYGD+V5N6d3jE/rwJvAgMBAAE=";
    private static final String PRIVATE_KEY = "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";

    @BeforeAll
    static void init() {
        rsaKeyPairGenerator = RsaUtil.getRsaKeyPair();
    }

    @Test
    void getRsaKeyPair() {
        String hexPrivateKey = Base64.getEncoder().encodeToString(
                rsaKeyPairGenerator.getPrivateKey().getEncoded());
        assertThat(RsaUtil.getPrivateKey(hexPrivateKey))
                .isEqualTo(rsaKeyPairGenerator.getPrivateKey());
        String hexPublicKey = Base64.getEncoder().encodeToString(
                rsaKeyPairGenerator.getPublicKey().getEncoded());
        assertThat(RsaUtil.getPublicKey(hexPublicKey))
                .isEqualTo(rsaKeyPairGenerator.getPublicKey());
    }

    @Test
    void isValidateRsaKeyPair() {
        assertThat(RsaUtil.isValidateRsaKeyPair(null))
                .isEqualTo(Boolean.FALSE);
        assertThat(RsaUtil.isValidateRsaKeyPair(rsaKeyPairGenerator))
                .isTrue();
    }

    @Test
    void encrypt() throws Exception {
        String encryptedText = RsaUtil.encrypt(text, RsaUtil.getPublicKey(PUBLIC_KEY));
        assertThat(RsaUtil.decrypt(encryptedText, RsaUtil.getPrivateKey(PRIVATE_KEY)))
                .isEqualTo(text);
    }

    @Test
    void decrypt() throws Exception {
        String encryptedText = RsaUtil.encrypt(text, rsaKeyPairGenerator.getPublicKey());
        assertThat(RsaUtil.decrypt(encryptedText, rsaKeyPairGenerator.getPrivateKey()))
                .isEqualTo(text);

    }
}