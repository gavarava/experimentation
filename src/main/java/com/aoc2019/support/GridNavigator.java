package com.aoc2019.support;

import java.util.ArrayList;
import java.util.List;

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

  private Point startingPoint;
  private Point latestPoint;
  private List<Point> pathTraversed;

  public GridNavigator(Point start) {
    startingPoint = start;
    latestPoint = Point.create(startingPoint.getX(), startingPoint.getY());
    pathTraversed = new ArrayList<>();
  }

  public GridNavigator move(int units, String directionAsString) {
    return move(units, Direction.valueOf(directionAsString));
  }

  public GridNavigator move(int units, Direction direction) {
    switch (direction) {
      case U:
        latestPoint = Point.create(latestPoint.getX(), latestPoint.getY() + units);
        pathTraversed.add(latestPoint);
        break;

      case D:
        int y = latestPoint.getY() - units;
        latestPoint = Point.create(latestPoint.getX(), y);
        pathTraversed.add(latestPoint);
        break;

      case R:
        latestPoint = Point.create(latestPoint.getX() + units, latestPoint.getY());
        pathTraversed.add(latestPoint);
        break;

      case L:
        int x = latestPoint.getX() - units;
        latestPoint = Point.create(x, latestPoint.getY());
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
}

