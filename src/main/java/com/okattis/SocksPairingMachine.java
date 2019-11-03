package com.okattis;

public class SocksPairingMachine {

    public static int getMovesToPairSocks(int[] pileOfSocks, int noOfPairs) {
        int[] auxiliaryPile = new int[pileOfSocks.length];
        int matchesFound = 0;
        int auxPileUpdateCount = 0;

        int innerLoopIterations = 0;
        int outerLoopIterations = 0;
        for (int i = 0; i < pileOfSocks.length; i++) {
            outerLoopIterations++;
            if (i == 0) {
                auxiliaryPile[i] = pileOfSocks[i];
                auxPileUpdateCount++;
            }

            for (int j = 0; j < auxPileUpdateCount; j++) {
                innerLoopIterations++;
                if (pileOfSocks[i] == auxiliaryPile[j]) {
                    noOfPairs--;
                    if (noOfPairs == 0) {
                        break;
                    }
                    matchesFound++;
                } else {
                    auxiliaryPile[auxPileUpdateCount] = pileOfSocks[i];
                }
            }
        }

        System.out.println(innerLoopIterations);
        System.out.println(outerLoopIterations);
        return matchesFound;
    }


    public static int getMovesToPairSocks2(int[] pileOfSocks, int noOfPairs) {
        int innerLoopCounter = 0;
        int outerLoopCounter = 0;

        int moves = 0;
        boolean auxPileUpdated = false;
        if (noOfPairs == 0) {
            return 0;
        }
        int[] auxiliaryPile = new int[pileOfSocks.length];
        for (int i = 0; i < pileOfSocks.length; i++) {
            outerLoopCounter++;

            // Initially when the Auxiliary Pile is empty
            if (!auxPileUpdated) {
                auxiliaryPile[i] = pileOfSocks[i];
                auxPileUpdated = true;
                moves++;
                continue;
            }

            boolean foundMatchInAuxiliaryPile = false;
            for (int j = i - 1; j >= 0; j--) {
                innerLoopCounter++;

                if (auxiliaryPile[j] == pileOfSocks[i]) {
                    foundMatchInAuxiliaryPile = true;
                    // Remove the matched one from the aux pile
                    auxiliaryPile[j] = 0;
                    j--;
                    moves++;

                    // Decrement the noOfPairs to ensure the boundary set by impossible
                    noOfPairs--;
                    if (noOfPairs == 0) {
                        break;
                    }
                }
            }

            if (!foundMatchInAuxiliaryPile) {
                auxiliaryPile[i] = pileOfSocks[i];
                moves++;
            }
        }

        if (noOfPairs != 0) {
            throw new RuntimeException("impossible");
        }

        System.out.println("innerLoopCounter = " + innerLoopCounter);
        System.out.println("outerLoopCounter = " + outerLoopCounter);

        return moves;
    }
}
