package com.aoc2019.support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Direction {
    U("U"), D("D"), R("R"), L("L");

    private final String directionValue;

    Direction(String directionString) {
        this.directionValue = directionString;
    }

    public String getDirectionValue() {
        return directionValue;
    }
}

public class GridNavigator {

    private static final int OFFSET_ARRAY_INDEX = 1;
    private Point startingPoint;
    private Point latestPoint;
    private List<Point> pathTraversed;
    private Map<Point, Integer> pointsToNumberOfStepsMap;

    public GridNavigator(Point start) {
        startingPoint = start;
        latestPoint = Point.create(startingPoint.getX(), startingPoint.getY());
        pathTraversed = new ArrayList<>();
        // resizing overhead
        pointsToNumberOfStepsMap = new HashMap<>(11000000, 1);
    }

    public GridNavigator move(int totalUnitsToMove, String directionAsString) {
        return move(totalUnitsToMove, Direction.valueOf(directionAsString));
    }

    public GridNavigator move(int totalUnitsToMove, Direction directionAsString) {
        GridNavigator latestGridNavigator = this;
        for (int i = 0; i < totalUnitsToMove; i++) {
            latestGridNavigator = move(directionAsString);
            pointsToNumberOfStepsMap.put(latestPoint, pathTraversed.indexOf(latestPoint) + OFFSET_ARRAY_INDEX);
        }
        return latestGridNavigator;
    }

    public GridNavigator move(Direction direction) {
        switch (direction) {
            case U:
                latestPoint = Point.create(latestPoint.getX(), latestPoint.getY() + 1);
                pathTraversed.add(latestPoint);
                break;

            case D:
                latestPoint = Point.create(latestPoint.getX(), latestPoint.getY() - 1);
                pathTraversed.add(latestPoint);
                break;

            case R:
                latestPoint = Point.create(latestPoint.getX() + 1, latestPoint.getY());
                pathTraversed.add(latestPoint);
                break;

            case L:
                latestPoint = Point.create(latestPoint.getX() - 1, latestPoint.getY());
                pathTraversed.add(latestPoint);
                break;
        }
        return this;
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Point startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Point getLatestPoint() {
        return latestPoint;
    }

    public void setLatestPoint(Point latestPoint) {
        this.latestPoint = latestPoint;
    }

    public List<Point> getPathTraversed() {
        return pathTraversed;
    }

    public void setPathTraversed(List<Point> pathTraversed) {
        this.pathTraversed = pathTraversed;
    }

    public Map<Point, Integer> getPointsToNumberOfStepsMap() {
        return pointsToNumberOfStepsMap;
    }
}

