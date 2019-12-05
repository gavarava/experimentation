package com.aoc2019;

import com.aoc2019.support.GridNavigator;
import com.aoc2019.support.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrossedWires {

  public static int findClosestIntersectingDistance(String[] wireOneCoordinates,
      String[] wireTwoCoordinates) {
    // Trace Wire Paths
    GridNavigator gridNavigatorStateWire01 = traceWirePaths(wireOneCoordinates);
    List<Point> pointsTraversedByWire01 = gridNavigatorStateWire01.getPathTraversed();
    GridNavigator gridNavigatorStateWire02 = traceWirePaths(wireTwoCoordinates);
    List<Point> pointsTraversedByWire02 = gridNavigatorStateWire02.getPathTraversed();

    System.out.println("Wire01 ->" + pointsTraversedByWire01);
    System.out.println("Wire02 ->" + pointsTraversedByWire02);
    // - findCommonCo-ordinates
    Point initialStartLine01 = Point.CENTRAL_PORT;
    Point initialStartLine02 = Point.CENTRAL_PORT;
    List<Point> intersections = new ArrayList<>();

    for (Point pointOnLine1 : pointsTraversedByWire01) {
      for (int i = 0; i < pointsTraversedByWire02.size(); i++) {
        Point pointOnLine2ToTest = pointsTraversedByWire02.get(i);
        Point intersectionBetweenTwoLines = findIntersectionBetweenTwoLines(initialStartLine01,
            pointOnLine1, initialStartLine02, pointOnLine2ToTest);
        if (intersectionBetweenTwoLines != null
            && !intersectionBetweenTwoLines.equals(Point.CENTRAL_PORT)) {
          intersections.add(
              intersectionBetweenTwoLines);
          initialStartLine02 = pointOnLine2ToTest;
        }
      }
      initialStartLine01 = pointOnLine1;
    }
    // - map common co-ordinates to Manhattan Distance
    // return lowest distance
    System.out.println(intersections);
    List<Integer> integerList = intersections.stream()
        .map(point -> calculateManhattanDistance(Point.CENTRAL_PORT, point)).sorted().collect(
            Collectors.toList());
    System.out.println(integerList);
    Integer answer = integerList.get(0);
    System.out.println("answer = " + answer);
    return answer;
  }

  public static Point findIntersectionBetweenTwoLines(Point x1, Point y1,
      Point x2, Point y2) {
    Point startWireOne = x1;
    Point endWireOne = y1;
    Point startWireTwo = x2;
    Point endWireTwo = y2;

    int a1 = endWireOne.getY() - startWireOne.getY();
    int a2 = endWireOne.getX() - startWireOne.getX();
    int c1 = a1 * startWireOne.getX() + a2 * startWireOne.getY();

    int b1 = endWireTwo.getY() - startWireTwo.getY();
    int b2 = endWireTwo.getX() - startWireTwo.getX();
    int c2 = b1 * startWireTwo.getX() + b2 * startWireTwo.getY();

    int delta = a1 * b2 - a2 * b1;
    if (delta == 0) {
      // The two lines dont meet
      return null;
    }
    return Point.create((b2 * c1 - b1 * c2) / delta, (a1 * c2 - a2 * c1) / delta);
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
