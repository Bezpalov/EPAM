package com.learning.batlleship.ships.concreteships;

import java.util.ArrayList;

/**
 * Realization of Abstract ship that represents a 4 deck ship
 */
public class FourDeckShip extends AbstractShip {

    public FourDeckShip() {
        points = new ArrayList<>(4);
        length = 4;
        lives = 4;
    }

    @Override
    public String toString() {
        return "FourDeckShip";
    }
}
