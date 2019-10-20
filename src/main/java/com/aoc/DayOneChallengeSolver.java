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
        int[] output = new int[input.length * 2];
        int j = 0;
        for (int i = 0; i < input.length; i++) {
            if (i == 0 && j == 0) {
                output[j] = input[i] + input[i + 1];
                i += 1;
                j++;
            } else {
                int latestFrequency = input[i] + output[j - 1];
                output[j] = latestFrequency;
                j++;
                if (checkRepetition(output)) {
                    return latestFrequency;
                }
            }
            if (i == input.length - 1 && j > 0) {
                // Reset the whole array
                i = 0;
            }
        }
        return 0;
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
