package com.aoc2019;

import static java.lang.Math.*;

import java.util.Arrays;

public class FuelCounterUpper {

    public static long calculateTotalFuelRequirement(long[] moduleMasses) {
        return Arrays
            .stream(moduleMasses)
            .map(FuelCounterUpper::fuelRequirementForEachModule).sum();
    }

    static long fuelRequirementForEachModule(long mass) {
        int fuel = round(mass / 3) - 2;
        if (fuel <= 0) {
            return 0L;
        }
        return fuel + fuelRequirementForEachModule(fuel);
    }


}
