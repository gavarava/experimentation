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
        InputFetcher inputFetcher = new InputFetcher("day01-input", ",");
        long [] inputData = inputFetcher.getInputDataAsArrayOfLongIntegers();
        long firstRepeatingFrequency = DayOneChallengeSolver.getFirstRepeatingFrequency(inputData);
        System.out.println("Ans2 Day One: " + firstRepeatingFrequency);
        // 55250 was the correct answer
        assertThat(firstRepeatingFrequency, not(0));
    }

    @Test
    void    shouldFirstRepeatingCumulativeFrequency_2() {
        long[] testArray2 = {-6, +3, +8, +5, -6, -6, +3, +8, +5, -6, -6, +3, +8, +5, -6, -6, +3, +8, +5, -6, -6, +3, +8, +5, -6, -6, +3, +8, +5, -6 ,-6, +3, +8, +5, -6 ,-6, +3, +8, +5, -6 ,-6, +3, +8, +5, -6 ,-6, +3, +8, +5, -6};
        long result = DayOneChallengeSolver.getFirstRepeatingFrequency(testArray2);
        assertEquals(5, result);
    }

    @Test
    void shouldFirstRepeatingCumulativeFrequency() {
        long[] testArrayX = {+1, -2, +3, +1, +1, -2, +3, +1, +1, -2, +3, +1, +1, -2, +3, +1, +1, -2, +3, +1, +1, -2, +3, +1, +1, -2, +3, +1};
        long[] testArray2 = {+7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4, +7, +7, -2, -7, -4};
        long expectedX = 2;
        DayOneChallengeSolver dayOneChallengeSolver = new DayOneChallengeSolver(null);
       // long result = dayOneChallengeSolver.getFirstRepeatingFrequency(testArrayX);
        //assertEquals(expectedX, result);
        assertEquals(14, dayOneChallengeSolver.getFirstRepeatingFrequency(testArray2));
    }
}