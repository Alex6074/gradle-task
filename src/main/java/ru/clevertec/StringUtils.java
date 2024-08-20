package ru.clevertec;

public class StringUtils {
    public static boolean isPositiveNumber(String str) {
        if (str == null)
            return false;

        try {
            return Double.parseDouble(str) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
