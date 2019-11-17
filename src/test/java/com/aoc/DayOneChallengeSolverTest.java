package com.aoc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.InputFetcher;
import org.junit.jupiter.api.Test;

class DayOneChallengeSolverTest {

    @Test
    void calculateResultingFrequency() {

        InputFetcher inputFetcher = new InputFetcher("day01-input");
        String inputData = inputFetcher.getInputDataAsString();
        String[] inputDataArray = inputData.split(",");

        DayOneChallengeSolver dayOneChallengeSolver = new DayOneChallengeSolver(inputDataArray);
        int resultingFrequency = dayOneChallengeSolver.calculateResultingFrequency();
        System.out.println("Ans1 Day One: " + resultingFrequency);
        assertThat(resultingFrequency, not(0));
    }

    @Test
    void findFirstFrequencyReachedTwice() {
        InputFetcher inputFetcher = new InputFetcher("day01-input");
        String inputData = inputFetcher.getInputDataAsString();
        String[] inputDataArray = inputData.split(",");

        DayOneChallengeSolver dayOneChallengeSolver = new DayOneChallengeSolver(inputDataArray);

        int firstRepeatingFrequency = dayOneChallengeSolver.findFirstRepeatingFrequency();
        System.out.println("Ans2 Day One: " + firstRepeatingFrequency);
    }

    @Test
    void shouldFirstRepeatingCumulativeFrequency_2() {
        int[] testArray2 = {-7, +7};
        int expected = 0;
        DayOneChallengeSolver dayOneChallengeSolver = new DayOneChallengeSolver(null);
        int result = dayOneChallengeSolver.getFirstRepeatingCumulativeFrequency(testArray2);
        assertEquals(expected, result);
    }

    @Test
    void shouldFirstRepeatingCumulativeFrequency() {
        int[] testArray2 = {7, +7, -2, -7, -4};
        int expected = 14;
        DayOneChallengeSolver dayOneChallengeSolver = new DayOneChallengeSolver(null);
        int result = dayOneChallengeSolver.getFirstRepeatingCumulativeFrequency(testArray2);
        assertEquals(expected, result);
    }
}