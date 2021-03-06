package com.learning.batlleship.ships.concreteships;

import java.util.ArrayList;

/**
 * Realization of Abstract ship that represents a 1 deck ship
 */
public class OneDeckShip extends AbstractShip {
    public OneDeckShip() {
        points = new ArrayList<>(1);
        length = 1;
        lives = 1;
    }

    @Override
    public String toString() {
        return "OneDeckShip";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
