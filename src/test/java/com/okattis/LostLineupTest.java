package com.okattis;

import static com.okattis.LostLineup.getOriginalLineOfPersons;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class LostLineupTest {

    @Test
    void getTheLostLineup_When_Case_1() {
        int[] newLineupWithNumberOfPersonsBetweenJimAndOthers = new int[]{0};
        int[] originalLineOfPersons = getOriginalLineOfPersons(2, newLineupWithNumberOfPersonsBetweenJimAndOthers);

        assertFalse(originalLineOfPersons.length == 0);

        printResult(originalLineOfPersons);
    }

    @Test
    void getTheLostLineup_When_Case_2() {
        int[] newLineupWithNumberOfPersonsBetweenJimAndOthers = new int[]{1, 2, 0};
        int[] originalLineOfPersons = getOriginalLineOfPersons(4, newLineupWithNumberOfPersonsBetweenJimAndOthers);

        assertFalse(originalLineOfPersons.length == 0);

        printResult(originalLineOfPersons);
    }

    @Test
    void getTheLostLineup_When_Case_3() {
        int[] newLineupWithNumberOfPersonsBetweenJimAndOthers = new int[]{2, 1, 0};
        int[] originalLineOfPersons = getOriginalLineOfPersons(4, newLineupWithNumberOfPersonsBetweenJimAndOthers);

        assertFalse(originalLineOfPersons.length == 0);

        printResult(originalLineOfPersons);
    }


    private void printResult(int[] originalLineOfPersons) {
        System.out.println("Original Lineup => ");
        for (int i = 0; i < originalLineOfPersons.length; i++) {
            System.out.print(originalLineOfPersons[i] + " ");
        }
    }

}