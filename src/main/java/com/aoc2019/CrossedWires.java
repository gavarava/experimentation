package com.aoc2019;

import com.aoc2019.support.GridNavigator;
import com.aoc2019.support.Point;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CrossedWires {

  public static int findClosestIntersectingDistance(String[] wireOneCoordinates,
      String[] wireTwoCoordinates) {
    // Trace Wire Paths
    GridNavigator gridNavigatorStateWire01 = traceWirePaths(wireOneCoordinates);
    List<Point> pointsTraversedByWire01 = gridNavigatorStateWire01.getPathTraversed();
    GridNavigator gridNavigatorStateWire02 = traceWirePaths(wireTwoCoordinates);
    List<Point> pointsTraversedByWire02 = gridNavigatorStateWire02.getPathTraversed();

    // - findCommonCo-ordinates
    Set<Point> intersectionOfTwoWires = pointsTraversedByWire01.stream()
        .distinct()
        .filter(pointsTraversedByWire02::contains)
        .collect(Collectors.toSet());
    System.out.println(intersectionOfTwoWires);
    // - map common co-ordinates to Manhattan Distance
    // return lowest distance
    if (intersectionOfTwoWires != null && !intersectionOfTwoWires.isEmpty()) {
      return calculateManhattanDistance(Point.CENTRAL_PORT,
          (Point) intersectionOfTwoWires.toArray()[0]);
    }
    return 0;
  }

  static GridNavigator traceWirePaths(String[] input) {
    GridNavigator gridNavigator = new GridNavigator(Point.CENTRAL_PORT);
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
