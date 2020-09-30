package com.zzh.util.util;

import com.google.common.hash.Hashing;
import io.seruco.encoding.base62.Base62;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.apache.commons.codec.digest.MurmurHash3;

import static com.google.common.base.Charsets.UTF_8;

/**
 * @author zhihao zhang
 * @since 9/4/20
 */

@UtilityClass
public class HashUtil {
    public final Base62 BASE_62 = Base62.createInstance();
    /**
     * generate a hash based on the num
     * @param num long
     * @return hash
     */
    public int hash32(long num) {
        return MurmurHash3.hash32(num);
    }

    /**
     * generate a hash based on the string text
     * @param text String
     * @return hash
     */
    public int hash32(@NonNull String text) {
        return MurmurHash3.hash32x86(text.getBytes());
    }


    /**
     * generate a hash based on the string text
     * @param text String
     * @return hash
     */
    public long[] hash128(@NonNull String text) {
        return MurmurHash3.hash128x64(text.getBytes());
    }

    /**
     * generate base62 text for hash
     * @param num int number
     * @return base62 text
     */
    public String base62(int num) {
        String numText = String.valueOf(num);
        byte[] encode = BASE_62.encode(numText.getBytes());
        return new String(encode);
    }

    /**
     * generate a hash based on the string text by guava
     * @param text String
     * @return hash
     */
    public int hash32byGuaua(@NonNull String text) {
        return Hashing.murmur3_32().hashString(text, UTF_8).asInt();
    }

    /**
     * generate sha hash based on the string
     * @param text String
     * @return sha hash string
     */
    public String sha(@NonNull String text) {
        return Hashing.sha256().hashString(text, UTF_8).toString();
    }

    /**
     * generate md5 hash based on the string
     * @param text String
     * @return md5 hash string
     */
    public String md5(@NonNull String text) {
        return Hashing.md5().hashString(text, UTF_8).toString();
    }
}
