package com.zzh.util.util;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EnumUtil {
    public static <T extends Enum<T>> Map<String, T> getEnumMap(final Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .collect(Collectors.toMap(Enum::name, Function.identity()));
    }
}
