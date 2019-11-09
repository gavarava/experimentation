package com.okattis;

public class LostLineup {

    public static int[] getOriginalLineOfPersons(int totalNumberOfPersons,
        int[] newLineupWithNumberOfPersonsBetweenJimAndOthers) {

        if (totalNumberOfPersons == 1) {
            return new int[]{1};
        }

        int[] originalLineup = new int[totalNumberOfPersons];
        // Jim is always first in line
        originalLineup[0] = 1;

        for (int i = 0; i < newLineupWithNumberOfPersonsBetweenJimAndOthers.length; i++) {
            int personsBetweenCurrentPersonAndJim = newLineupWithNumberOfPersonsBetweenJimAndOthers[i];
            originalLineup[personsBetweenCurrentPersonAndJim+1] = i+2;
        }

        return originalLineup;
    }

}
