package com.aoc2019.intcode.support;

public class InstructionValidator {

    private int[] intCodeProgram;
    private int instructionPointer;

    public InstructionValidator(int[] intCodeProgram, int instructionPointer) {
        this.intCodeProgram = intCodeProgram;
        this.instructionPointer = instructionPointer;
    }

    public boolean isInvalidInstruction() {
        if (intCodeProgram.length < 4) {
            return false;
        }
        if (checkInstructionPointerWithinIntCodeProgramLength()) {
            if (checkAddressGivenByInstructionPointerWithinIntCodeProgramLength()) {
                return checkValuesGivenByAddressGivenByInstructionPointerWithinIntCodeProgramLength();
            }
        }
        return false;
    }


    private boolean checkInstructionPointerWithinIntCodeProgramLength() {
        return (instructionPointer + 3 > intCodeProgram.length)
            || (instructionPointer + 2 > intCodeProgram.length)
            || (instructionPointer + 1 > intCodeProgram.length);
    }

    private boolean checkAddressGivenByInstructionPointerWithinIntCodeProgramLength() {
        return (intCodeProgram[instructionPointer + 3] > intCodeProgram.length)
            || (intCodeProgram[instructionPointer + 2] > intCodeProgram.length)
            || (intCodeProgram[instructionPointer + 1] > intCodeProgram.length);
    }

    private boolean checkValuesGivenByAddressGivenByInstructionPointerWithinIntCodeProgramLength() {
        try {
            return (intCodeProgram[intCodeProgram[instructionPointer + 3]] > intCodeProgram.length)
                || (intCodeProgram[intCodeProgram[instructionPointer + 2]] > intCodeProgram.length)
                || (intCodeProgram[intCodeProgram[instructionPointer + 1]] > intCodeProgram.length);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
