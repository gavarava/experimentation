package com.aoc2019;

import com.InputFetcher;
import org.junit.jupiter.api.Test;

class FuelCounterUpperTest {

    @Test
    void calculateFuel() {

        InputFetcher inputFetcher = new InputFetcher("aoc2019-d1", "\n");
        long[] input = inputFetcher.getInputDataAsArrayOfLongIntegers();

         long result = FuelCounterUpper.calculateTotalFuelRequirement(input);

        System.out.println("ANS Day01 Challenge01 = " + result);
    }

    @Test
    void calculateFuelOneModuleRecursively() {

        InputFetcher inputFetcher = new InputFetcher("aoc2019-d1", "\n");

        long result = FuelCounterUpper.fuelRequirementForEachModule(100756L);

        System.out.println("fuelRequirementForEachModule = " + result);
    }

}