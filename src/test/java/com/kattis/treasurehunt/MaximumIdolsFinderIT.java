package com.kattis.treasurehunt;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;

class MaximumIdolsFinderIT {

    private static final String WHITESPACE = "\\s";

    private static final String FILE_PATH = "/home/gaurav/development/learning/myprojects/adventofcode-2018/src/main/resources/";

    private MaximumIdolsFinder maximumIdolsFinder;

    @Test
    void calculateNumberOfIdolsRecoverable_WHEN_MANY_INTER_CONNECTED_CAVES_II() throws FileNotFoundException {
        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver
            .initializeFromFile(FILE_PATH + "treasurehunt/treasurehunt_when_many_interconnected_caves_II");
        maximumIdolsFinder = treasureDiveSolver.getMaximumIdolsFinder();
        assertThat(maximumIdolsFinder.calculateNumberOfIdolsRecoverable(treasureDiveSolver.getAvailableUnitsOfAir()), is(5));
    }


    @Test
    void calculateNumberOfIdolsRecoverable_WHEN_MANY_INTER_CONNECTED_CAVES() throws FileNotFoundException {
        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver
            .initializeFromFile(FILE_PATH + "treasurehunt/treasurehunt_when_many_interconnected_caves");
        maximumIdolsFinder = treasureDiveSolver.getMaximumIdolsFinder();
        assertThat(maximumIdolsFinder.calculateNumberOfIdolsRecoverable(treasureDiveSolver.getAvailableUnitsOfAir()), is(8));
    }


    @Test
    void calculateNumberOfIdolsRecoverable() throws FileNotFoundException {
        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver
            .initializeFromFile(FILE_PATH + "treasurehunt/treasurehunt_onecave_onetunnel_fouridol");
        maximumIdolsFinder = treasureDiveSolver.getMaximumIdolsFinder();
        assertThat(maximumIdolsFinder.calculateNumberOfIdolsRecoverable(treasureDiveSolver.getAvailableUnitsOfAir()), is(4));
    }

    @Test
    void calculateNumberOfIdolsRecoverable2() throws FileNotFoundException {
        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver
            .initializeFromFile(FILE_PATH + "treasurehunt/treasurehunt_onecave_onetunnel_fouridol");
        maximumIdolsFinder = treasureDiveSolver.getMaximumIdolsFinder();
        assertThat(maximumIdolsFinder.calculateNumberOfIdolsRecoverable(treasureDiveSolver.getAvailableUnitsOfAir()), is(4));
    }

    @Test
    void calculateNumberOfIdolsRecoverable3() throws FileNotFoundException {
        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver
            .initializeFromFile(FILE_PATH + "treasurehunt/treasurehunt_3cave_3tunnel_4idol");
        maximumIdolsFinder = treasureDiveSolver.getMaximumIdolsFinder();
        assertThat(maximumIdolsFinder.calculateNumberOfIdolsRecoverable(treasureDiveSolver.getAvailableUnitsOfAir()), is(8));
    }

    @Test
    void calculateNumberOfIdolsRecoverable_KattisBasicInput() throws FileNotFoundException {
        TreasureDiveSolver treasureDiveSolver = new TreasureDiveSolver();
        treasureDiveSolver
            .initializeFromFile(FILE_PATH + "treasurehunt/treasurehunt1");
        maximumIdolsFinder = treasureDiveSolver.getMaximumIdolsFinder();
        assertThat(maximumIdolsFinder.calculateNumberOfIdolsRecoverable(treasureDiveSolver.getAvailableUnitsOfAir()), is(1));
    }
}
