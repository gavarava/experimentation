package com.kattis.treasurehunt;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;

public class TreasureDivingTest {

    @Test
    void maximumNumberOfIdolsPossible() throws FileNotFoundException {

        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver.initializeFromFile(
            "/home/gaurav/development/learning/myprojects/experimentation/src/main/resources/treasurehunt/treasurehunt_when_many_interconnected_caves_II");
        treasureDiveSolver.printNumberOfIdolsRecoverableFromCaveSystem(System.out);
    }

}
