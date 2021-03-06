package com.aoc2019;

import com.InputFetcher;

public class AdvancedIntCodeComputer extends IntCodeComputer {

    public static void main(String[] args) {
        InputFetcher inputFetcher = new InputFetcher("aoc2019-d5", ",");
        int[] input = inputFetcher.getInputDataAsArrayOfIntegers();
        AdvancedIntCodeComputer advancedIntCodeComputer = new AdvancedIntCodeComputer();
        int answer = advancedIntCodeComputer.completeGravityAssist(input);
        System.out.println("ANS Day-04 Part-01: " + answer);
    }

    @Override
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

    static void executeInstruction_4(int[] intCodeProgram, int instructionPointer) {

    }

    static void executeInstruction_3(int[] intCodeProgram, int instructionPointer) {

    }

}
