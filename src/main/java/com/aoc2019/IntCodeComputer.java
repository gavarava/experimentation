package com.aoc2019;

import com.InputFetcher;

public class IntCodeComputer {

    private static final int EXPECTED_OUTPUT = 19690720;

    public int completeGravityAssist(int[] intCodeProgram) {
        int result = 0;
        // Testing all values in the range 0 to 99 for the noun and the verbs
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 1; verb < 100; verb++) {
                int[] resultant = runIntCodeProgram(intCodeProgram, noun,
                    verb);
                result = resultant[0];
                if (result == EXPECTED_OUTPUT) {
                    System.out.println("NOUN = " + noun);
                    System.out.println("VERB = " + verb);
                    return 100 * noun + verb;
                }
                intCodeProgram = resetInputByFetchingAgain();
            }
        }
        return result;
    }

    private static int[] resetInputByFetchingAgain() {
        InputFetcher inputFetcher = new InputFetcher("aoc2019-d2", ",");
        return inputFetcher.getInputDataAsArrayOfIntegers();
    }

    protected int[] runIntCodeProgram(int[] intCodeProgram, int noun, int verb) {
        int instructionPointer = 0;

        intCodeProgram[instructionPointer + 1] = noun;
        intCodeProgram[instructionPointer + 2] = verb;

        while (instructionPointer < intCodeProgram.length) {
            switch (intCodeProgram[instructionPointer]) {
                case 99:
                    // HALT PROGRAM
                    return intCodeProgram;
                case 1:
                    executeInstruction_1(intCodeProgram, instructionPointer);
                    break;
                case 2:
                    executeInstruction_2(intCodeProgram, instructionPointer);
                    break;
            }
            instructionPointer += 4;
        }
        return intCodeProgram;
    }

    static void executeInstruction_2(int[] intCodeProgram, int instructionPointer) {
        if (instructionPointer + 3 > intCodeProgram.length) {
             System.err.println("BAD STATE 2A");
        } else if (intCodeProgram[instructionPointer + 3] > intCodeProgram.length) {
             System.err.println("BAD STATE 2B");
        } else if (intCodeProgram[intCodeProgram[instructionPointer + 3]] > intCodeProgram.length) {
              System.err.println("BAD STATE 2C");
        } else {
            intCodeProgram[intCodeProgram[instructionPointer + 3]] =
                intCodeProgram[intCodeProgram[instructionPointer + 1]] * intCodeProgram[intCodeProgram[
                    instructionPointer + 2]];
        }
    }

    static void executeInstruction_1(int[] intCodeProgram, int instructionPointer) {
        if (instructionPointer + 3 > intCodeProgram.length) {
                 System.err.println("BAD STATE 1A");
        } else if (intCodeProgram[instructionPointer + 3] > intCodeProgram.length) {
                 System.err.println("BAD STATE 1B");
        } else if (intCodeProgram[intCodeProgram[instructionPointer + 3]] > intCodeProgram.length) {
                 System.err.println("BAD STATE 1C");
        } else {
            intCodeProgram[intCodeProgram[instructionPointer + 3]] =
                intCodeProgram[intCodeProgram[instructionPointer + 1]] + intCodeProgram[intCodeProgram[
                    instructionPointer + 2]];
        }
    }
}
