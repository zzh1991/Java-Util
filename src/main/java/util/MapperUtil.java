package util;

import com.jsoniter.JsonIterator;
import com.jsoniter.spi.TypeLiteral;
import lombok.experimental.UtilityClass;

/**
 * @author zhihao zhang
 * @date 2019-04-10
 */

@UtilityClass
public class MapperUtil {

    /**
     * may throw exception, should catch
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getObjectFromJson(String json, Class<T> clazz) {
        return JsonIterator.deserialize(replaceSingleQuote(json), clazz);
    }

    private static String replaceSingleQuote(String json) {
        return json.replace('\'', '"');
    }

    /**
     * may throw exception, should catch
     * @param json
     * @param typeLiteral
     * @param <T>
     * @return
     */
    public static <T> T getObjectFromJson(String json, TypeLiteral<T> typeLiteral) {
        return JsonIterator.deserialize(replaceSingleQuote(json), typeLiteral);
    }
}
