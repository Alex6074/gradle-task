package ru.clevertec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testIsAllPositiveNumbers_allPositive() {
        String[] input = {"123.4", "456", "789.10"};
        boolean result = Utils.isAllPositiveNumbers(input);
        assertTrue(result);
    }

    @Test
    void testIsAllPositiveNumbers_containsNegative() {
        String[] input = {"123.4", "-456", "789.10"};
        boolean result = Utils.isAllPositiveNumbers(input);
        assertFalse(result);
    }

    @Test
    void testIsAllPositiveNumbers_containsNonNumeric() {
        String[] input = {"123.4", "abc", "789.10"};
        boolean result = Utils.isAllPositiveNumbers(input);
        assertFalse(result);
    }

    @Test
    void testIsAllPositiveNumbers_containsNull() {
        String[] input = {"123.4", "abc", "789.10", null};
        boolean result = Utils.isAllPositiveNumbers(input);
        assertFalse(result);
    }

    @Test
    void testIsAllPositiveNumbers_emptyArray() {
        boolean result = Utils.isAllPositiveNumbers();
        assertFalse(result);
    }
}