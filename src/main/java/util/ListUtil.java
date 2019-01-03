package util;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListUtil {
    public static <T> List<List<T>> splitListToSmallLists(List<T> bigList, int splitSize) {
        if (isListNullOrEmpty(bigList)) {
            return Lists.newArrayList();
        }
        return Lists.partition(bigList, splitSize);
    }

    public static <T> List<T> concat(List<T> firstList, List<T> secondList) {
        List<T> allList = Lists.newArrayList();
        addAllToList(allList, firstList);
        addAllToList(allList, secondList);
        return allList;
    }

    public static <T> void addAllToList(List<T> targetList, List<T> list) {
        if (isListNullOrEmpty(list)) {
            return;
        }
        targetList.addAll(list);
    }

    public static <T> boolean isListNullOrEmpty(List<T> list) {
        return Objects.isNull(list) || list.isEmpty();
    }

    public static <T> List<T> union(List<T> firstList, List<T> secondList) {
        return Lists.newArrayList(Sets.newHashSet(concat(firstList, secondList)));
    }

    public static <T> List<T> intersection(List<T> firstList, List<T> secondList) {
        if (isListNullOrEmpty(firstList) || isListNullOrEmpty(secondList)) {
            return Lists.newArrayList();
        }
        List<T> intersectionList = Lists.newArrayList(firstList);
        intersectionList.retainAll(secondList);
        return intersectionList;
    }

    public static <T> List<T> difference(List<T> firstList, List<T> secondList) {
        if (isListNullOrEmpty(firstList) && isListNullOrEmpty(secondList)) {
            return Lists.newArrayList();
        }

        if (isListNullOrEmpty(firstList)) {
            return secondList;
        }

        if (isListNullOrEmpty(secondList)) {
            return firstList;
        }
        return firstList.stream()
                .filter(item -> !secondList.contains(item))
                .collect(Collectors.toList());
    }

    public static List<String> splitStringToList(String text, String separator) {
        if (Strings.isNullOrEmpty(text)) {
            return Lists.newArrayList();
        }
        return Lists.newArrayList(text.split(separator));
    }

    public static String joinListToString(List<String> list, String separator) {
        return String.join(separator, list);
    }
}
