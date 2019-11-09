package com.zzh.util.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * @author zhihao zhang
 * @date 2019-07-10
 */

public final class EncryptUtil {
    private static final String AES = "AES";
    private static final String SHA_1_PRNG = "SHA1PRNG";
    private static final int KEY_SIZE = 128;

    private EncryptUtil() {}

    public static String encrypt(String text, String key) {
        try {
            Key aesKey = generateKey(key);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encryptBytes = cipher.doFinal(text.getBytes());
            return ByteHexUtil.bytesToHexString(encryptBytes);
        } catch (Exception e) {
            return "";
        }
    }

    public static String decrypt(String encryptString, String key) {
        try {
            Key aesKey = generateKey(key);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            return new String(cipher.doFinal(ByteHexUtil.hexStringToBytes(encryptString)));
        } catch (Exception e) {
            return "";
        }
    }

    private static SecretKeySpec generateKey(final String key) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
            SecureRandom secureRandom = SecureRandom.getInstance(SHA_1_PRNG);
            secureRandom.setSeed(key.getBytes());
            keyGenerator.init(KEY_SIZE, secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encodedFormat = secretKey.getEncoded();
            return new SecretKeySpec(encodedFormat, AES);
        } catch (Exception e) {
            return null;
        }
    }
}
