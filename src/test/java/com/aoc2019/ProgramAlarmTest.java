package com.aoc2019;

import static com.aoc2019.ProgramAlarm.completeGravityAssist;
import static com.aoc2019.ProgramAlarm.resetGravityAssistComputer;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.InputFetcher;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ProgramAlarmTest {

    @Test
    void restoreComputer_SmallInput() {
        int[] input = new int[] {2,4,4,5,99,0};
/*        Arrays.stream(resetGravityAssistComputer(input, 4, 4))
            .forEach(value -> System.out.print(value + " "));*/
        System.out.println();
        System.out.println("restoreComputer_SmallInput = " + input[0]);
    }

    @Test
    void restoreComputer() {
        InputFetcher inputFetcher = new InputFetcher("aoc2019-d2", ",");
        int[] input = inputFetcher.getInputDataAsArrayOfIntegers();
/*        Arrays.stream(resetGravityAssistComputer(input, 12, 2))
            .forEach(value -> System.out.print(value + " "));*/
        System.out.println();
        // 3058646 is the answer
        System.out.println("Ans D02 Ch01 = " + input[0]);
        assertTrue(input[0] == 3058646);
    }

    @Test
    void restoreComputer_MultipleInputs() {
        int[] input1 = new int[] {2,4,4,5,99,0};
        System.out.println("restoreComputer_MultipleInputs = " + resetGravityAssistComputer(input1, 4,4)[0]);
    }

    @Test
    void restoreComputer_MultipleInputs2() {
        int[] input2 = new int[] {1,1,1,4,99,5,6,0,99};
        System.out.println("restoreComputer_MultipleInputs = " + resetGravityAssistComputer(input2, 1,1)[0]);
    }


    @Test
    void completeGravityAssistProgram_SmallInput() {
        int[] input = new int[] {2,4,4,5,99,0};
        System.out.println("completeGravityAssistProgram_SmallInput = " + completeGravityAssist(input));
    }

    @Test
    void completeGravityAssistProgram() {
        InputFetcher inputFetcher = new InputFetcher("aoc2019-d2", ",");
        int[] input = inputFetcher.getInputDataAsArrayOfIntegers();
        System.out.println("Ans D02 Ch01 = " + completeGravityAssist(input));
    }


}