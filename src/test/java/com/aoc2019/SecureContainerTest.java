package com.aoc2019;

import static com.aoc2019.SecureContainer.doesDigitsStaySameOrIncreasingOrder;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SecureContainerTest {

    @Test
    void testValidation_doesDigitsStaySame() {
        int testInput1 = 111123;
        assertFalse(doesDigitsStaySameOrIncreasingOrder(testInput1));

        int testInput1A = 122345;
        assertTrue(doesDigitsStaySameOrIncreasingOrder(testInput1A));

        int testInput2 = 123789;
        assertFalse(doesDigitsStaySameOrIncreasingOrder(testInput2));

        int testInput3 = 223450;
        assertFalse(doesDigitsStaySameOrIncreasingOrder(testInput3));

        int testInputX = 112233;
        assertTrue(doesDigitsStaySameOrIncreasingOrder(testInputX));

        int testInput1Y = 113444;
        assertFalse(doesDigitsStaySameOrIncreasingOrder(testInput1Y));
    }

    @Test
    void testValidation_doesDigitsStaySame_PART_II() {
        int testInput2 = 111123;
        assertTrue(doesDigitsStaySameOrIncreasingOrder(testInput2));
    }

}