package com.aoc2019.support;

import java.util.Objects;

public class Point {

    public static final Point CENTRAL_PORT = new Point(0, 0);

    private int x;
    private int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point create(int x, int y) {
        return new Point(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x &&
            y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + "x=" + x + ", y=" + y + ')';
    }
}
