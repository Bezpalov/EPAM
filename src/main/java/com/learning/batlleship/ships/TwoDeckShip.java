package main.java.com.learning.batlleship.ships;

import main.java.com.learning.batlleship.Point;
import main.java.com.learning.batlleship.ships.AbstractShip;

import java.util.ArrayList;

public class TwoDeckShip extends AbstractShip {
    public TwoDeckShip() {
        points = new ArrayList<>(2);
    }
}
