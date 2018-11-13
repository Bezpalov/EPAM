package main.java.com.learning.batlleship.ships.fabric;

import main.java.com.learning.batlleship.ships.OneDeckShip;
import main.java.com.learning.batlleship.ships.Ship;

public class OneDeckShipCreator implements ShipFactory {

    @Override
    public Ship createShip() {
        return new OneDeckShip();
    }

    @Override
    public Ship[] createSetOfShips() {
        Ship[] ships = {new OneDeckShip(), new OneDeckShip(),
                        new OneDeckShip(), new OneDeckShip()};
        return ships;
    }
}
