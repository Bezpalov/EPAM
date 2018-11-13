package main.java.com.learning.batlleship.ships.fabric;

import main.java.com.learning.batlleship.ships.Ship;

public interface ShipFactory {
    Ship createShip();
    Ship[] createSetOfShips();
}
