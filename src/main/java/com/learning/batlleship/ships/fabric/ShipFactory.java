package com.learning.batlleship.ships.fabric;

import com.learning.batlleship.ships.concreteships.Ship;

public interface ShipFactory {
    Ship createShip();
    Ship[] createSetOfShips();
}
