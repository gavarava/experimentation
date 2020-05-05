package com.aoc2019;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.InputFetcher;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntCodeComputerTest {

    private IntCodeComputer intCodeComputer;

    @BeforeEach
    void setup() {
        intCodeComputer = new IntCodeComputer();
    }

    @Test
    void restoreComputer_SmallInput() {
        int[] input = new int[]{2, 4, 4, 5, 99, 0};
/*        Arrays.stream(resetGravityAssistComputer(input, 4, 4))
            .forEach(value -> System.out.print(value + " "));*/
        System.out.println();
        System.out.println("restoreComputer_SmallInput = " + input[0]);
    }

    @Test
    void restoreComputer() {
        InputFetcher inputFetcher = new InputFetcher("aoc2019-d2", ",");
        int[] input = inputFetcher.getInputDataAsArrayOfIntegers();
        Arrays.stream(intCodeComputer.runIntCodeProgram(input, 12, 2))
            .forEach(value -> System.out.print(value + " "));
        System.out.println();
        // 3058646 is the answer
        System.out.println("Ans D02 Ch01 = " + input[0]);
        assertEquals(3058646, input[0]);
    }

    @Test
    void restoreComputer_MultipleInputs() {
        int[] input1 = new int[]{2, 4, 4, 5, 99, 0};
        System.out.println("restoreComputer_MultipleInputs = " + intCodeComputer.runIntCodeProgram(input1, 4, 4)[0]);
    }

    @Test
    void restoreComputer_MultipleInputs2() {
        int[] input2 = new int[]{1, 1, 1, 4, 99, 5, 6, 0, 99};
        System.out.println("restoreComputer_MultipleInputs = " + intCodeComputer.runIntCodeProgram(input2, 1, 1)[0]);
    }


    @Test
    void completeGravityAssistProgram_SmallInput() {
        int[] input = new int[]{2, 4, 4, 5, 99, 0};
        System.out.println("completeGravityAssistProgram_SmallInput = " + intCodeComputer.completeGravityAssist(input));
    }

    @Test
    void completeGravityAssistProgram() {
        InputFetcher inputFetcher = new InputFetcher("aoc2019-d2", ",");
        int[] input = inputFetcher.getInputDataAsArrayOfIntegers();
        System.out.println("Ans D02 Ch01 = " + intCodeComputer.completeGravityAssist(input));
    }


}