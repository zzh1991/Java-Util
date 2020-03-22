package com.zzh.util.util;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author zhihao zhang
 * @since 2020.03.22
 */

public class StringUtil {
    private static Pattern pattern = Pattern.compile("\\b(?=\\w)");

    public static String capitalizeEveryWord(final String text) {
        if (Strings.isNullOrEmpty(text)) {
            return "";
        }
        return pattern.splitAsStream(text)
                .map(StringUtils::capitalize)
                .collect(Collectors.joining());
    }
}
