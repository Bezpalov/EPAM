package com.learning.batlleship.ships.fabric;

import com.learning.batlleship.ships.concreteships.Ship;
import com.learning.batlleship.ships.concreteships.TwoDeckShip;

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
