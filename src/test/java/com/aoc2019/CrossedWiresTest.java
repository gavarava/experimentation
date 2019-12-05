package com.aoc2019;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.aoc2019.support.Point;
import org.junit.jupiter.api.Test;

class CrossedWiresTest {

    @Test
    void calculateManhattanDistance_samepoint() {
        assertThat(CrossedWires.calculateManhattanDistance(Point.create(0, 0), Point.create(0, 0)), is(0));
    }

    @Test
    void calculateManhattanDistance() {
        assertThat(CrossedWires.calculateManhattanDistance(Point.create(1, 3), Point.create(3, 8)), is(7));
    }

}