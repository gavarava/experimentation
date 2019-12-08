package com.aoc2019;

import static com.aoc2019.support.Point.CENTRAL_PORT;

import com.aoc2019.support.GridNavigator;
import com.aoc2019.support.Point;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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

        Map<Point, Integer> numberOfStepsMap = recordNumberOfSteps(pathTraversedWireOne, pathTraversedWireTwo,
            intersectionOfTwoWires);
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

    private static Map<Point, Integer> recordNumberOfSteps(List<Point> pathTraversedWireOne,
        List<Point> pathTraversedWireTwo,
        Set<Point> intersectionOfTwoWires) {
        // Create Map of intersecting points to number of steps
        Map<Point, Integer> pointsToNumberOfStepsMap = new HashMap<>();
        for (Point intersectingPoint : intersectionOfTwoWires) {
            int numberOfStepsInWireOne = pathTraversedWireOne.indexOf(intersectingPoint) + 1;
            int numberOfStepsInWireTwo = pathTraversedWireTwo.indexOf(intersectingPoint) + 1;
            int totalNumberOfStepsTravelled = numberOfStepsInWireOne + numberOfStepsInWireTwo;
            if (pointsToNumberOfStepsMap.containsKey(intersectingPoint)) {
                Integer totalNumberOfStepsPreviouslyCalculated = pointsToNumberOfStepsMap.get(intersectingPoint);
                if (totalNumberOfStepsTravelled < totalNumberOfStepsPreviouslyCalculated) {
                    pointsToNumberOfStepsMap.put(intersectingPoint, totalNumberOfStepsTravelled);
                }
            } else {
                pointsToNumberOfStepsMap.put(intersectingPoint, totalNumberOfStepsTravelled);
            }
        }

        return pointsToNumberOfStepsMap;
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
