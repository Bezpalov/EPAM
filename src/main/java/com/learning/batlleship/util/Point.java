package com.learning.batlleship.util;

import java.util.Objects;

/**
 * Class representing a point on a map
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * getter for a x coordinate
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * setter for a x coordinate
     * @param x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter for a y coordinate
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * setter for a y coordinate
     * @param y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return getX() == point.getX() &&
                getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
