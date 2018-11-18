package com.learning.batlleship.ships.fabric;

import com.learning.batlleship.ships.concreteships.OneDeckShip;
import com.learning.batlleship.ships.concreteships.Ship;

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
