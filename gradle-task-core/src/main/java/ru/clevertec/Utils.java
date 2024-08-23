package ru.clevertec;

import java.util.Arrays;
import ru.clevertec.StringUtils;

public class Utils {
    public static boolean isAllPositiveNumbers(String ... str) {
        if (str.length == 0)
            return false;

        return Arrays.stream(str).allMatch(StringUtils::isPositiveNumber);
    }
}
