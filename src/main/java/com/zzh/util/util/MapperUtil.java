package com.zzh.util.util;

import com.jsoniter.JsonIterator;
import com.jsoniter.spi.TypeLiteral;
import lombok.experimental.UtilityClass;

/**
 * @author zhihao zhang
 * @since 2019-04-10
 */

@UtilityClass
public class MapperUtil {

    /**
     * may throw exception, should catch
     * @param json json text
     * @param clazz class
     * @param <T> generic class
     * @return generic class
     */
    public static <T> T getObjectFromJson(String json, Class<T> clazz) {
        return JsonIterator.deserialize(replaceSingleQuote(json), clazz);
    }

    private static String replaceSingleQuote(String json) {
        return json.replace('\'', '"');
    }

    /**
     * may throw exception, should catch
     * @param json json text
     * @param typeLiteral type
     * @param <T> generic class
     * @return generic class
     */
    public static <T> T getObjectFromJson(String json, TypeLiteral<T> typeLiteral) {
        return JsonIterator.deserialize(replaceSingleQuote(json), typeLiteral);
    }
}
