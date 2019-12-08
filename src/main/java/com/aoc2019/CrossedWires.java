package com.aoc2019;

import static com.aoc2019.support.Point.CENTRAL_PORT;

import com.aoc2019.support.GridNavigator;
import com.aoc2019.support.Point;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CrossedWires {

    public static int findClosestIntersectingDistance(String[] wireOneCoordinates,
        String[] wireTwoCoordinates) {
        long startTime = System.currentTimeMillis();
        // Trace Wire Paths
        GridNavigator gridNavigator = CrossedWires.traceWirePaths(wireOneCoordinates);
        List<Point> pathTraversedWireOne = gridNavigator.getPathTraversed();
        GridNavigator gridNavigator2 = CrossedWires.traceWirePaths(wireTwoCoordinates);
        List<Point> pathTraversedWireTwo = gridNavigator2.getPathTraversed();

        // - findCommonCo-ordinates
        Set<Point> intersectionOfTwoWires = new HashSet<>();
        for (Point pointOneW1 : pathTraversedWireOne) {
            if (pathTraversedWireTwo.contains(pointOneW1) && !pointOneW1.equals(CENTRAL_PORT)) {
                intersectionOfTwoWires.add(pointOneW1);
            }
        }
        int result = 0;
        // return lowest distance
        if (!intersectionOfTwoWires.isEmpty()) {
            result = intersectionOfTwoWires.stream()
                .map(point -> calculateManhattanDistance(CENTRAL_PORT, point))
                .collect(Collectors.toList()).stream().sorted().findFirst().orElse(0);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("ANS: Day03 P1 = " + result);
        int shortestPath = recordNumberOfSteps(gridNavigator, gridNavigator2, intersectionOfTwoWires);
        System.out.println("ANS: Day03 P2 = " + shortestPath);
        System.out.println("Total time taken = " + (endTime - startTime) / 1000 + " seconds");
        return result;
    }

    private static int recordNumberOfSteps(GridNavigator gridNavigatorWireOne,
        GridNavigator gridNavigatorWireTwo,
        Set<Point> intersectionOfTwoWires) {
        Map<Point, Integer> pointsToNumberOfStepsMap1 = gridNavigatorWireOne.getPointsToNumberOfStepsMap();
        Map<Point, Integer> pointsToNumberOfStepsMap2 = gridNavigatorWireTwo.getPointsToNumberOfStepsMap();
        return intersectionOfTwoWires.stream()
            .map(point -> pointsToNumberOfStepsMap1.get(point) + pointsToNumberOfStepsMap2.get(point))
            .collect(Collectors.toList()).stream().sorted().findFirst().orElse(Integer.MAX_VALUE);
    }

    static GridNavigator traceWirePaths(String[] input) {
        GridNavigator gridNavigator = new GridNavigator(CENTRAL_PORT);
        for (String coordinate : input) {
            String direction = coordinate.substring(0, 1);
            Integer distance = Integer.valueOf(coordinate.substring(1).stripTrailing());
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
