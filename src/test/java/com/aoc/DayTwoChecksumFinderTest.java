package com.aoc;

import static com.aoc.DayTwoChecksumFinder.calculateChecksum;
import static com.aoc.DayTwoChecksumFinder.countOfTwoOfAnyLetter;

import com.InputFetcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class DayTwoChecksumFinderTest {

    private String[] input;

    @BeforeAll
    void parseInput() {
        InputFetcher inputFetcher = new InputFetcher("day02-input", "\n");
        input = inputFetcher.getInputDataAsArrayOfStrings();
    }

    @Test
    void findChecksum() {
        System.out.println("Ans Day02 = " + calculateChecksum(input));
    }

    @Test
    void countOfTwos() {
        String input = "abbcde";
        System.out.println("countOfTwoOfAnyLetter for " + input + " --- " + countOfTwoOfAnyLetter(input));
    }

    @Test
    void countOfThrees() {
        String input = "abbbcde";

    }

}
