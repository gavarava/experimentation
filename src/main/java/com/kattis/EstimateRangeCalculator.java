package com.kattis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class EstimateRangeCalculator {

    private static final String EXPONENT = "^";
    private static final String EXPONENT_REGEX = "\\^";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        long numberOfInputs = sc.nextInt();
        while (sc.hasNext()) {
            if (numberOfInputs == 0) {
                break;
            }
            System.out.println(calculateNumberOfDigitsInEstimatedCost(sc.next()));
            numberOfInputs--;
        }
    }

    private static long calculateNumberOfDigitsInEstimatedCost(String estimatedCost) {
        if (estimatedCost.contains(EXPONENT)) {
            BigInteger estimatedCostBigInt = convertExponentToBigInteger(estimatedCost);
            return estimatedCostBigInt.toString().length();
        } else {
            return estimatedCost.length();
        }
    }

    private static BigInteger convertExponentToBigInteger(String estimatedCost) {
        String[] split = estimatedCost.split(EXPONENT_REGEX);
        BigInteger bigInteger = new BigInteger((split[0])).pow(Integer.valueOf(split[1]));
        return bigInteger;
    }
}
