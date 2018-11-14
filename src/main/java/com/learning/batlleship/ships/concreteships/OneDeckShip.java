package main.java.com.learning.batlleship.ships.concreteships;

import java.util.ArrayList;

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
}
