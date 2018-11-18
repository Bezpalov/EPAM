package com.learning.batlleship.ships.fabric;

import com.learning.batlleship.ships.concreteships.FourDeckShip;
import com.learning.batlleship.ships.concreteships.Ship;

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
