package com.aoc2019.support;

import static com.aoc2019.support.Direction.*;
import static com.aoc2019.support.Direction.RIGHT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class GridNavigatorTest {

    @Test
    void moveRightTwice() {
        Point startingPoint = Point.CENTRAL_PORT;
        GridNavigator gridNavigator = new GridNavigator(startingPoint);
        gridNavigator.move(5, RIGHT);
        gridNavigator.move(5, RIGHT);

        Point expectedPoint = Point.create(10, 0);
        assertThat(gridNavigator.getLatestPoint(), is(equalTo(expectedPoint)));
    }

    @Test
    void moveUpFiveTimes() {
        Point startingPoint = Point.CENTRAL_PORT;
        GridNavigator gridNavigator = new GridNavigator(startingPoint);
        gridNavigator.move(3, UP);
        gridNavigator.move(2, UP);
        gridNavigator.move(-3, UP);
        gridNavigator.move(9, UP);

        Point expectedPoint = Point.create(0, 11);
        assertThat(gridNavigator.getLatestPoint(), is(equalTo(expectedPoint)));
    }

    @Test
    void moveLeftTwoTimes() {
        Point startingPoint = Point.CENTRAL_PORT;
        GridNavigator gridNavigator = new GridNavigator(startingPoint);
        gridNavigator.move(3, UP);
        gridNavigator.move(2, UP);
        gridNavigator.move(-3, UP);
        gridNavigator.move(9, UP);

        Point expectedPoint = Point.create(0, 11);
        assertThat(gridNavigator.getLatestPoint(), is(equalTo(expectedPoint)));
    }

    @Test
    void moveDownThreeTimesUpThreeTimes() {
        Point startingPoint = Point.CENTRAL_PORT;
        GridNavigator gridNavigator = new GridNavigator(startingPoint);
        gridNavigator.move(3, DOWN);
        gridNavigator.move(2, DOWN);
        gridNavigator.move(3, DOWN);
        gridNavigator.move(3, UP);
        gridNavigator.move(2, UP);
        gridNavigator.move(3, UP);

        Point expectedPoint = Point.CENTRAL_PORT;
        assertThat(gridNavigator.getLatestPoint(), is(equalTo(expectedPoint)));
    }

    @Test
    void navigateMultiplePointsAndReturnToStartingPoint() {
        // R75,D30,R83
        Point startingPoint = Point.CENTRAL_PORT;
        GridNavigator gridNavigator = new GridNavigator(startingPoint);
        gridNavigator.move(75, RIGHT);
        gridNavigator.move(30, DOWN);
        gridNavigator.move(83, RIGHT);

        gridNavigator.move(83, LEFT);
        gridNavigator.move(30, UP);
        gridNavigator.move(75, LEFT);
        assertThat(gridNavigator.getLatestPoint(), is(equalTo(Point.CENTRAL_PORT)));
    }
}