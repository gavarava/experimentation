package com.aoc2019;

import com.InputFetcher;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ProgramAlarmTest {

    @Test
    void restoreComputer() {
        InputFetcher inputFetcher = new InputFetcher("aoc2019-d2", ",");
        int[] input = inputFetcher.getInputDataAsArrayOfIntegers();
        Arrays.stream(ProgramAlarm.reset(input)).forEach(value -> System.out.print(value + " "));
        System.out.println("Ans D02 Ch01 = " + input[0]);
    }




}