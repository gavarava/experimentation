package com.aoc2019;

public class ProgramAlarm {

    public static int[] reset(int[] intCodeProgram) {
        int currentIndex = 0;
        intCodeProgram[currentIndex + 1] = 12;
        intCodeProgram[currentIndex + 2] = 2;
        while (currentIndex < intCodeProgram.length) {
            switch (intCodeProgram[currentIndex]) {
                case 1:
                    intCodeProgram[intCodeProgram[currentIndex + 3]] =
                        intCodeProgram[intCodeProgram[currentIndex + 1]] + intCodeProgram[intCodeProgram[currentIndex + 2]];
                    break;
                case 2:
                    intCodeProgram[intCodeProgram[currentIndex + 3]] =
                        intCodeProgram[intCodeProgram[currentIndex + 1]] * intCodeProgram[intCodeProgram[currentIndex + 2]];
                    break;
                case 99:
                    return intCodeProgram;
            }
            currentIndex += 4;
        }
        return intCodeProgram;
    }

}
