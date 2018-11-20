package com.learning.batlleship.ships.concreteships;

import com.learning.batlleship.util.Point;

import java.util.ArrayList;

/**
 * Interface that must implements every ship
 */
public interface Ship {
    ArrayList<Point> getCoordinates();

    /**
     * Set coordinates for a concrete ship.
     * Coordinates takes from List with Point objects
     *
     * @param points ArrayList with coordinates inside
     */
    void setCoordinates(ArrayList<Point> points);

    /**
     * Check if the ship is hit
     *
     * @param point coordinates of a shot
     * @return true - if shot was successful
     * false - if shot wasn't successful
     */
    boolean isHit(Point point);

    /**
     * check if the ship is alive
     *
     * @return true - if alive
     * false - if not alive
     */
    boolean isOnWater();

    /**
     * gives a number of the rest of lives
     *
     * @return count of lives
     */
    int getLives();

    /**
     * gives a number of ship length
     *
     * @return
     */
    int getLength();
}
