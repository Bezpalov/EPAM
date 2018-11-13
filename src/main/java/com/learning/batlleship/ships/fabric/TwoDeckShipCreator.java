package main.java.com.learning.batlleship.ships.fabric;

import main.java.com.learning.batlleship.ships.Ship;
import main.java.com.learning.batlleship.ships.TwoDeckShip;

public class TwoDeckShipCreator implements ShipFactory {
    @Override
    public Ship createShip() {
        return new TwoDeckShip();
    }

    @Override
    public Ship[] createSetOfShips() {
        Ship[] ships = {new TwoDeckShip(), new TwoDeckShip(),
                        new TwoDeckShip()};
        return ships;
    }
}
