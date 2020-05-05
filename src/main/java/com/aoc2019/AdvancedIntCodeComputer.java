package com.aoc2019;

import com.InputFetcher;

public class AdvancedIntCodeComputer extends IntCodeComputer {

    private static final int INPUT_VALUE_FROM_SYSTEM = 1;

    public static void main(String[] args) {
        InputFetcher inputFetcher = new InputFetcher("aoc2019-d5", ",");
        int[] input = inputFetcher.getInputDataAsArrayOfIntegers();
        AdvancedIntCodeComputer advancedIntCodeComputer = new AdvancedIntCodeComputer();
        int answer = advancedIntCodeComputer.completeGravityAssist(input);
        System.out.println("ANS Day-04 Part-01: " + answer);
    }

    static void executeInstruction_4(int[] intCodeProgram, int instructionPointer) {
        System.out.println(intCodeProgram[instructionPointer]);
    }

    static void executeInstruction_3(int[] intCodeProgram, int instructionPointer) {
        intCodeProgram[instructionPointer] = INPUT_VALUE_FROM_SYSTEM;
    }

    @Override
    protected int[] runIntCodeProgram(int[] intCodeProgram, int noun, int verb) {
        int instructionPointer = 0;

        if (intCodeProgram.length > 2) {
            intCodeProgram[instructionPointer + 1] = noun;
            intCodeProgram[instructionPointer + 2] = verb;
        }

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
                case 3:
                    executeInstruction_3(intCodeProgram, instructionPointer);
                    break;
                case 4:
                    executeInstruction_4(intCodeProgram, instructionPointer);
                    break;
            }
            instructionPointer += 4;
        }
        return intCodeProgram;
    }

}
