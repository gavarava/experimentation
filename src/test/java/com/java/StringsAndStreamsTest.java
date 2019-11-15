package com.java;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class StringsAndStreamsTest {

    @Test
    void test_SelfDescribingNumbers() {
        /**
         *   0 1 2 3
         *   1 2 1 0
         *   Numbers Digit is describing the number of times the array index is present or not
         *
         */
        assertFalse(isSelfDescribingNumber(1211));
        assertTrue(isSelfDescribingNumber(1210));
        assertTrue(isSelfDescribingNumber(2020));
        assertTrue(isSelfDescribingNumber(72100001000L));
        assertTrue(isSelfDescribingNumber(3211000));
        assertFalse(isSelfDescribingNumber(3211010));
    }

    private boolean isSelfDescribingNumber(long number) {
        String numberAsString = String.valueOf(number);
        String[] numberArray = numberAsString.split("");
        boolean found = false;
        for (int i = 0; i < numberArray.length; i++) {
            final long arrayIndexAsDigitToBeSearched = i;
            long countOfIndexInNumber = Arrays.asList(numberArray).stream()
                .filter(chars -> chars.equals(String.valueOf(arrayIndexAsDigitToBeSearched))).count();
            String expectedCountInNumberItself = numberArray[i];
            if (countOfIndexInNumber != Integer.valueOf(expectedCountInNumberItself)) {
                return false;
            } else {
                found = true;
            }
        }
        return found;
    }

}
