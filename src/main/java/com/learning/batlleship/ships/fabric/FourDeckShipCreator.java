package main.java.com.learning.batlleship.ships.fabric;

import main.java.com.learning.batlleship.ships.concreteships.FourDeckShip;
import main.java.com.learning.batlleship.ships.concreteships.Ship;

public class FourDeckShipCreator implements ShipFactory {
    @Override
    public Ship createShip() {
        return new FourDeckShip();
    }

    @Override
    public Ship[] createSetOfShips() {
        Ship[] ships = {new FourDeckShip()};
        return ships;
    }
}
