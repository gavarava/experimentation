package com.kattis.treasurehunt;

import java.io.FileNotFoundException;

public class TreasureDiving {

    public static void main(String[] args) throws FileNotFoundException {
        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver.initializeFromFile("/home/gaurav/development/learning/myprojects/adventofcode-2018/src/main/resources/treasurehunt/treasurehunt_when_many_interconnected_caves_II");
        treasureDiveSolver.printNumberOfIdolsRecoverableFromCaveSystem(System.out);
    }
}
