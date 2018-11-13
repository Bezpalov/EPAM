package main.java.com.learning.batlleship.ships;

import main.java.com.learning.batlleship.Point;
import main.java.com.learning.batlleship.ships.AbstractShip;

import java.util.ArrayList;

public class ThreeDeckShip extends AbstractShip {
    public ThreeDeckShip() {
        points = new ArrayList<>(3);
    }
}
