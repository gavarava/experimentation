package com.aoc2019.support;

import static com.aoc2019.support.Direction.*;
import static com.aoc2019.support.Direction.R;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class GridNavigatorTest {

    @Test
    void moveRightTwice() {
        Point startingPoint = Point.CENTRAL_PORT;
        GridNavigator gridNavigator = new GridNavigator(startingPoint);
        gridNavigator.move(5, "R");
        gridNavigator.move(5, "R");

        Point expectedPoint = Point.create(10, 0);
        assertThat(gridNavigator.getLatestPoint(), is(equalTo(expectedPoint)));
    }

    @Test
    void moveUpFiveTimes() {
        Point startingPoint = Point.CENTRAL_PORT;
        GridNavigator gridNavigator = new GridNavigator(startingPoint);
        gridNavigator.move(3, U);
        gridNavigator.move(2, U);
        gridNavigator.move(-3, U);
        gridNavigator.move(9, U);

        Point expectedPoint = Point.create(0, 11);
        assertThat(gridNavigator.getLatestPoint(), is(equalTo(expectedPoint)));
    }

    @Test
    void moveLeftTwoTimes() {
        Point startingPoint = Point.CENTRAL_PORT;
        GridNavigator gridNavigator = new GridNavigator(startingPoint);
        gridNavigator.move(3, U);
        gridNavigator.move(2, U);
        gridNavigator.move(-3, U);
        gridNavigator.move(9, U);

        Point expectedPoint = Point.create(0, 11);
        assertThat(gridNavigator.getLatestPoint(), is(equalTo(expectedPoint)));
    }

    @Test
    void moveDownThreeTimesUpThreeTimes() {
        Point startingPoint = Point.CENTRAL_PORT;
        GridNavigator gridNavigator = new GridNavigator(startingPoint);
        gridNavigator.move(3, D);
        gridNavigator.move(2, D);
        gridNavigator.move(3, D);
        gridNavigator.move(3, U);
        gridNavigator.move(2, U);
        gridNavigator.move(3, U);

        Point expectedPoint = Point.CENTRAL_PORT;
        assertThat(gridNavigator.getLatestPoint(), is(equalTo(expectedPoint)));
    }

    @Test
    void navigateMultiplePointsAndReturnToStartingPoint() {
        // R75,D30,R83
        Point startingPoint = Point.CENTRAL_PORT;
        GridNavigator gridNavigator = new GridNavigator(startingPoint);
        gridNavigator.move(75, R);
        gridNavigator.move(30, U);
        gridNavigator.move(83, R);

        gridNavigator.move(83, L);
        gridNavigator.move(30, D);
        gridNavigator.move(75, L);
        assertThat(gridNavigator.getLatestPoint(), is(equalTo(Point.CENTRAL_PORT)));
    }

    @Test
    void navigateMultiplePointsAndReturnToStartingPoint_updateTraversal() {
        // R75,D30,R83
        Point startingPoint = Point.CENTRAL_PORT;
        GridNavigator gridNavigator = new GridNavigator(startingPoint);
        gridNavigator.move(75, R);
        gridNavigator.move(30, U);
        gridNavigator.move(83, R);

        gridNavigator.move(83, L);
        gridNavigator.move(30, D);
        gridNavigator.move(75, L);
        assertThat(gridNavigator.getLatestPoint(), is(equalTo(Point.CENTRAL_PORT)));
        assertThat(gridNavigator.getPathTraversed().toString(), is("[(x=75, y=0), (x=75, y=-30), (x=158, y=-30), (x=75, y=-30), (x=75, y=0), (x=0, y=0)]"));
    }
}