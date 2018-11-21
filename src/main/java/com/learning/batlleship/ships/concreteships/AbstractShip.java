package com.learning.batlleship.ships.concreteships;

import com.learning.batlleship.util.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that represents basic ship
 */
public abstract class AbstractShip implements Ship {
    protected List<Point> points;
    protected int lives;
    protected int length;

    @Override
    public List<Point> getCoordinates() {
        return points;
    }

    @Override
    public void setCoordinates(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("points must exist"); }
        this.points = points;
    }

    @Override
    public boolean isHit(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("point must exist");
        }
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).equals(point)) {

                lives--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isOnWater() {
        return lives > 0;
    }

    /**
     * Getter for gives lives of a concrete ship
     *
     * @return lives of a ship
     */
    public int getLives() {
        return lives;
    }

    /**
     * Gettter for gives a length of a ship
     *
     * @return length of a ship
     */
    public int getLength() {
        return length;
    }
}
