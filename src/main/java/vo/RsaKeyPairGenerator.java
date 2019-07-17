package vo;

import lombok.Data;

import java.security.*;

/**
 * @author zhihao zhang
 * @date 2019-07-16
 */

@Data
public class RsaKeyPairGenerator {
    public static final String RSA = "RSA";
    private static final int KEY_SIZE = 3072;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public RsaKeyPairGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(RSA);
        keyGen.initialize(KEY_SIZE);
        KeyPair pair = keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }
}
