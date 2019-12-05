package com.aoc2019;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.InputFetcher;
import com.aoc2019.support.GridNavigator;
import com.aoc2019.support.Point;
import java.util.List;
import org.junit.jupiter.api.Test;

class CrossedWiresTest {


  public static final int OFFSET_CENTRAL_PORT = 1;

    @Test
    void findClosestIntersectingDistance_SMALL_INPUT_2() {
        String[] wireOnePoints = {"R98","U47","R26","D63","R33","U87","L62","D20","R33","U53","R51"};
        String[] wireTwoPoints = {"U98","R91","D20","R16","D67","R40","U7","R15","U6","R7"};
        GridNavigator gridNavigator = CrossedWires.traceWirePaths(wireOnePoints);
        List<Point> pathTraversed = gridNavigator.getPathTraversed();
        System.out.println(pathTraversed);
        System.out.println(CrossedWires.calculateManhattanDistance(Point.CENTRAL_PORT, pathTraversed.get(pathTraversed.size()- 1)));
        GridNavigator gridNavigator2 = CrossedWires.traceWirePaths(wireTwoPoints);
        List<Point> pathTraversed2 = gridNavigator2.getPathTraversed();
        System.out.println(pathTraversed2);
        System.out.println(CrossedWires.calculateManhattanDistance(Point.CENTRAL_PORT, pathTraversed2.get(pathTraversed2.size()- 1)));

        System.out.println(CrossedWires.calculateManhattanDistance(pathTraversed.get(pathTraversed.size()- 1), pathTraversed2.get(pathTraversed2.size()- 1)));

        System.out.println(CrossedWires.findClosestIntersectingDistance(wireOnePoints, wireTwoPoints));
    }

  @Test
  void findClosestIntersectingDistance_SMALL_INPUT() {
    InputFetcher inputFetcher = new InputFetcher("aoc2019-d3", "\n");
    String[] inputDataAsArrayOfStrings = inputFetcher.getInputDataAsArrayOfStrings();
    String[] wireOnePoints = {"R75","D30","R83","U83","L12","D49","R71","U7","L72"};
    String[] wireTwoPoints = {"U62","R66","U55","R34","D71","R55","D58","R83"};
      GridNavigator gridNavigator = CrossedWires.traceWirePaths(wireOnePoints);
      List<Point> pathTraversed = gridNavigator.getPathTraversed();
      System.out.println(pathTraversed);
      System.out.println(CrossedWires.calculateManhattanDistance(Point.CENTRAL_PORT, pathTraversed.get(pathTraversed.size()- 1)));
      GridNavigator gridNavigator2 = CrossedWires.traceWirePaths(wireTwoPoints);
      List<Point> pathTraversed2 = gridNavigator2.getPathTraversed();
      System.out.println(pathTraversed2);
      System.out.println(CrossedWires.calculateManhattanDistance(Point.CENTRAL_PORT, pathTraversed2.get(pathTraversed2.size()- 1)));

      System.out.println(CrossedWires.calculateManhattanDistance(pathTraversed.get(pathTraversed.size()- 1), pathTraversed2.get(pathTraversed2.size()- 1)));

      // System.out.println(CrossedWires.findClosestIntersectingDistance(wireOnePoints, wireTwoPoints));
  }

  @Test
  void translateInput() {
    InputFetcher inputFetcher = new InputFetcher("aoc2019-d3", "\n");
    String[] inputDataAsArrayOfStrings = inputFetcher.getInputDataAsArrayOfStrings();
    String[] wireOnePoints = inputDataAsArrayOfStrings[0].split(",");

    GridNavigator gridNavigator = CrossedWires.traceWirePaths(wireOnePoints);

    assertThat(gridNavigator.getPathTraversed().size() - OFFSET_CENTRAL_PORT,
        is(equalTo(wireOnePoints.length)));
    //System.out.println(gridNavigator.getPathTraversed().toString());
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