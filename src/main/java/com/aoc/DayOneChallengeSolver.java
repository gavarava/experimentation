package com.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DayOneChallengeSolver {

    private String[] inputFrequencies;

    public DayOneChallengeSolver(String[] inputFrequencies) {
        this.inputFrequencies = inputFrequencies;
    }

    public static long getFirstRepeatingFrequency(long[] input) {
        List<Long> frequencyMap = new ArrayList<>();
        long change = 0;
        int j = 0;
        int loopBreaker = 0;
        System.out.println("input length is = " + input.length);
        while (j < input.length) {
            change += input[j];
            if (frequencyMap.contains(change)) {
                System.out.println("FOUND CHANGE = " + change + " at location --> " + frequencyMap.indexOf(change));
                System.out.println("LOOP BREAKING AT " + loopBreaker);
                break;
            } else {
                frequencyMap.add(change);
            }
            if (j == input.length - 1) {
                j = 0;
            } else {
                j++;
            }
            if (loopBreaker == (input.length - 1) * 1000000L) {
                System.out.println("loopBreaker = " + loopBreaker);
                System.out.println("LOOP BREAKING AT " + change);
                break;
            } else {
                loopBreaker++;
            }
        }
        return change;
    }

    public int calculateResultingFrequency() {
        int sum = Stream
            .of(inputFrequencies)
            .mapToInt(s -> Integer.parseInt(s)).sum();
        return sum;
    }
}
