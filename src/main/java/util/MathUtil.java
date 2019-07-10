package util;

import java.util.Objects;
import java.util.stream.IntStream;

public class MathUtil {
    public double average(int[] array) {
        if (Objects.isNull(array) || array.length == 0) {
            return 0;
        }
        return IntStream.of(array)
                .average()
                .orElse(0);
    }
}
