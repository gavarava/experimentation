package com.aoc;

import java.util.HashMap;

public class DayTwoChecksumFinder {

    public static long calculateChecksum(String[] input) {
        return 0;
    }

    static int countOfTwoOfAnyLetter(String input) {
        char[] chars = input.toCharArray();
        HashMap<String, Integer> countersMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (countersMap.containsKey(chars[i])) {

            } else {

            }
           // countersMap.put(chars[i], chars[i])
            System.out.println(chars[i]);
        }
        return 0;
    }

    static int countOfThreeOfAnyLetter(String input) {
        return 0;
    }

}
