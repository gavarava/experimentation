package com.aoc2019.support;

import java.util.ArrayList;
import java.util.List;

enum Direction {
    UP, DOWN, RIGHT, LEFT;
}

public class GridNavigator {

    private Point startingPoint;
    private Point latestPoint;
    private List<Point> pathTraversed;

    public GridNavigator(Point start) {
        startingPoint = start;
        latestPoint = Point.create(startingPoint.getX(), startingPoint.getY());
        pathTraversed = new ArrayList<>();
    }

    public GridNavigator move(int units, Direction direction) {
        if (pathTraversed.isEmpty()) {
            pathTraversed.add(startingPoint);
        }
        switch (direction) {
            case UP:
                latestPoint.setY(latestPoint.getY() + units);
                break;

            case DOWN:
                latestPoint.setY(latestPoint.getY() - units);
                break;

            case RIGHT:
                latestPoint.setX(latestPoint.getX() + units);
                break;

            case LEFT:
                latestPoint.setX(latestPoint.getX() - units);
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
}

