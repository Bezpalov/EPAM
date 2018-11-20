package com.learning.batlleship.ships.fabric;

import com.learning.batlleship.ships.concreteships.Ship;

/**
 * Interface that should implements every
 * ship factory
 */
public interface ShipFactory {
    /**
     * Method for creating a one concrete ship
     *
     * @return one concrete ship
     */
    Ship createShip();

    /**
     * Method for creating a standard set of ships:
     * one 4-deck ship, two 3-deck ship, three 2-deck ship,
     * four 1-deck ship
     *
     * @return array with set of ships
     */
    Ship[] createSetOfShips();
}
