package main.java.com.learning.batlleship.ships.concreteships;

import java.util.ArrayList;

public class TwoDeckShip extends AbstractShip {
    public TwoDeckShip() {
        points = new ArrayList<>(2);
        length = 2;
        lives = 2;
    }

    @Override
    public String toString() {
        return "TwoDeckShip";
    }
}
