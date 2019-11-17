package com.aoc;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DayOneChallengeSolver {

    private String[] inputFrequencies;

    public DayOneChallengeSolver(String[] inputFrequencies) {
        this.inputFrequencies = inputFrequencies;
    }

    public int calculateResultingFrequency() {
        int sum = Stream
            .of(inputFrequencies)
            .mapToInt(s -> Integer.parseInt(s)).sum();
        return sum;
    }

    public int findFirstRepeatingFrequency() {
        IntStream intStream = Stream
            .of(inputFrequencies)
            .mapToInt(s -> Integer.parseInt(s));
        return getFirstRepeatingCumulativeFrequency(intStream.toArray());
    }

    int getFirstRepeatingCumulativeFrequency(int[] input) {
        int index = 0;
        int traversedLengthOfInput = input.length;
        int sum = 0;
        int cycleSum = 0;
        while (traversedLengthOfInput != 0) {
            sum += input[index];
            ++index;
            --traversedLengthOfInput;
            if (traversedLengthOfInput == 0 && index == input.length) {
                cycleSum = sum;
                // reset
                index = 0;
                traversedLengthOfInput = input.length;
            } else {
                if (cycleSum == sum) {
                    break;
                }
            }
        }
        return cycleSum;
    }

    private boolean checkRepetition(int[] testArray) {
        for (int i = 0; i < testArray.length; i++) {
            for (int j = i + 1; j < testArray.length; j++) {
                if (testArray[i] == testArray[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
