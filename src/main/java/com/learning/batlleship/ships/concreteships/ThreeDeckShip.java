package com.learning.batlleship.ships.concreteships;

import java.util.ArrayList;

/**
 * Realization of Abstract ship that represents a 3 deck ship
 */
public class ThreeDeckShip extends AbstractShip {
    public ThreeDeckShip() {
        points = new ArrayList<>(3);
        length = 3;
        lives = 3;
    }

    @Override
    public String toString() {
        return "ThreeDeckShip";
    }
}
