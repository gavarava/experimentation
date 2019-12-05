package com.aoc2019;

import com.aoc2019.support.Point;

public class CrossedWires {

    static int calculateManhattanDistance(Point p1, Point p2) {
        if (!p1.equals(p2)) {
            return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
        }
        return 0;
    }

}
