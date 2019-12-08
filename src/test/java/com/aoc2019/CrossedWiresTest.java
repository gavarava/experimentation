package com.aoc2019;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.InputFetcher;
import com.aoc2019.support.GridNavigator;
import com.aoc2019.support.Point;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CrossedWiresTest {

    @Test
    void solveCrossedWiresProblem() {
        InputFetcher inputFetcher = new InputFetcher("aoc2019-d3", "\n");
        String[] inputDataAsArrayOfStrings = inputFetcher.getInputDataAsArrayOfStrings();
        String[] wireOnePoints = inputDataAsArrayOfStrings[0].split(",");
        String[] wireTwoPoints = inputDataAsArrayOfStrings[1].split(",");
        int result = CrossedWires.findClosestIntersectingDistance(wireOnePoints, wireTwoPoints);
        // Ans P1 = 529
        // Ans P2 = 20386
        assertThat(result, is(equalTo(529)));
    }

    @Test
    void findClosestIntersectingDistance_SMALL_INPUT() {
        InputFetcher inputFetcher = new InputFetcher("aoc2019-d3", "\n");
        String[] inputDataAsArrayOfStrings = inputFetcher.getInputDataAsArrayOfStrings();
        String[] wireOnePoints = {"R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"};
        String[] wireTwoPoints = {"U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83"};
        int result = CrossedWires
            .findClosestIntersectingDistance(wireOnePoints, wireTwoPoints);
        assertThat(result, is(equalTo(159)));
    }

    @Test
    void findClosestIntersectingDistance_SMALL_INPUT_2() {
        String[] wireOnePoints = {"R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53",
            "R51"};
        String[] wireTwoPoints = {"U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7"};
        GridNavigator gridNavigator = CrossedWires.traceWirePaths(wireOnePoints);
        List<Point> pathTraversed = gridNavigator.getPathTraversed();
        System.out.println("Line1 - " + pathTraversed);
        GridNavigator gridNavigator2 = CrossedWires.traceWirePaths(wireTwoPoints);
        List<Point> pathTraversed2 = gridNavigator2.getPathTraversed();
        System.out.println("Line2 - " + pathTraversed2);

        int result = CrossedWires.findClosestIntersectingDistance(wireOnePoints, wireTwoPoints);
        assertThat(result, is(equalTo(135)));
    }

    @Test
    void testSimplestInput() {
        String[] wireOnePoints = {"R8", "U5", "L5", "D3"};
        String[] wireTwoPoints = {"U7", "R6", "D4", "L4"};

        int result = CrossedWires
            .findClosestIntersectingDistance(wireOnePoints, wireTwoPoints);

        // 6,5 and 3,3 are the commons
        assertThat(result, is(equalTo(6)));
    }

    @Test
    void calculateManhattanDistance_samepoint() {
        assertThat(CrossedWires.calculateManhattanDistance(Point.create(0, 0), Point.create(0, 0)),
            is(0));
    }

    @Test
    void calculateManhattanDistance() {
        assertThat(CrossedWires.calculateManhattanDistance(Point.create(1, 3), Point.create(3, 8)),
            is(7));
    }

}