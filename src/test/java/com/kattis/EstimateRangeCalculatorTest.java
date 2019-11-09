/*
package com.kattis;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class EstimateRangeCalculatorTest {

    // Checking Running time for Big Integer and without as well

    @Test
    void getNumberOfDigits_LongMaxValue() {
        long startTime = System.currentTimeMillis();
        long numberOfDigits = EstimateRangeCalculator.calculateNumberOfDigits(new BigInteger(
            String.valueOf(Long.MAX_VALUE)));
        long endTime = System.currentTimeMillis();

        System.out
            .println("Running time for Big Int of Long.MAX_VALUE digits => " + (endTime - startTime) + " milliseconds");
    }

    @Test
    void getNumberOfDigits_FOR_25_DIGIT_BigInteger() {
        long startTime = System.currentTimeMillis();
        long numberOfDigits = EstimateRangeCalculator.calculateNumberOfDigits(new BigInteger(
            "1000000000000000000000000"));
        long endTime = System.currentTimeMillis();

        System.out.println("Running time for Big Int of 25 digits => " + (endTime - startTime) + " milliseconds");
    }

    @Test
    void getNumberOfDigits_FOR_90_DIGIT_BigInteger() {
        long startTime = System.currentTimeMillis();
        long numberOfDigits = EstimateRangeCalculator.calculateNumberOfDigits(new BigInteger(
            "1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        long endTime = System.currentTimeMillis();

        System.out.println("Running time for Big Int of 100 digits => " + (endTime - startTime) + " milliseconds");

        doTestAgain();
    }

    private void doTestAgain() {
        long startTime = System.currentTimeMillis();
        long numberOfDigits = EstimateRangeCalculator.calculateNumberOfDigits(new BigInteger(
            "200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        long endTime = System.currentTimeMillis();

        System.out.println("Running time for Big Int of 90 digits => " + (endTime - startTime) + " milliseconds");
    }


    @Test
    void getNumberOfDigits_FOR_180_DIGIT_BigInteger() {
        long startTime = System.currentTimeMillis();
        long numberOfDigits = EstimateRangeCalculator.calculateNumberOfDigits(new BigInteger(
            "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        long endTime = System.currentTimeMillis();

        System.out.println("Running time for Big Int of 180 digits => " + (endTime - startTime) + " milliseconds");
    }

    @Test
    void getNumberOfDigits_FOR_270_DIGIT_BigInteger() {
        long startTime = System.currentTimeMillis();
        long numberOfDigits = EstimateRangeCalculator.calculateNumberOfDigits(new BigInteger(
            "100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        long endTime = System.currentTimeMillis();

        System.out.println("Running time for Big Int of 270 digits => " + (endTime - startTime) + " milliseconds");
    }
}*/
