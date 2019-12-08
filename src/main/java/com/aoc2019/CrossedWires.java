package com.aoc2019;

import static com.aoc2019.support.Point.CENTRAL_PORT;

import com.aoc2019.support.GridNavigator;
import com.aoc2019.support.Point;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CrossedWires {

    public static int findClosestIntersectingDistance(String[] wireOneCoordinates,
        String[] wireTwoCoordinates) {
        long startTime = System.currentTimeMillis();
        // Trace Wire Paths
        GridNavigator gridNavigator1 = CrossedWires.traceWirePaths(wireOneCoordinates);
        List<Point> pathTraversedWireOne = gridNavigator1.getPathTraversed();
        // - findCommonCo-ordinates
        GridNavigator gridNavigator2 = CrossedWires.traceWirePaths(wireTwoCoordinates, pathTraversedWireOne);
        Set<Point> intersectionOfTwoWires = gridNavigator2.getIntersectionsEncountered();

        Map<Point, Integer> numberOfStepsMap = gridNavigator2.getPointsToNumberOfStepsMap();
        Optional<Entry<Point, Integer>> minValue = numberOfStepsMap.entrySet()
            .stream().min(Entry.comparingByValue());
        // Warning:(39, 58) 'Optional.get()' without 'isPresent()' check
        System.out.println("ANS: Day03 P2 = " + minValue.get().getValue());

        int result = 0;
        // return lowest distance
        if (!intersectionOfTwoWires.isEmpty()) {
            result = intersectionOfTwoWires.stream()
                .map(point -> calculateManhattanDistance(CENTRAL_PORT, point))
                .collect(Collectors.toList()).stream().sorted().findFirst().orElse(0);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ANS: Day03 P1 = " + result);
        System.out.println("Total time taken = " + (endTime - startTime) / 1000 + " seconds");
        return result;
    }

    static GridNavigator traceWirePaths(String[] input) {
        GridNavigator gridNavigator = new GridNavigator(CENTRAL_PORT);
        return tracePaths(input, gridNavigator);
    }

    static GridNavigator traceWirePaths(String[] input, List<Point> earlierPathTraversed) {
        GridNavigator gridNavigator = new GridNavigator(CENTRAL_PORT, earlierPathTraversed);
        return tracePaths(input, gridNavigator);
    }

    private static GridNavigator tracePaths(String[] input, GridNavigator gridNavigator) {
        for (String coordinate : input) {
            String direction = coordinate.substring(0, 1);
            int distance = Integer.parseInt(coordinate.substring(1).stripTrailing());
            gridNavigator = gridNavigator.move(distance,
                direction);
        }
        return gridNavigator;
    }

    static int calculateManhattanDistance(Point p1, Point p2) {
        if (!p1.equals(p2)) {
            return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
        }
        return 0;
    }

}
