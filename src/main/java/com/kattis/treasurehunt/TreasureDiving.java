package com.kattis.treasurehunt;

public class TreasureDiving {

    public static void main(String[] args) {
        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver.initializeFromSystemIn();
        treasureDiveSolver.printNumberOfIdolsRecoverableFromCaveSystem(System.out);
    }
}
