package com.learning.battleship.ships.fabric;

import com.learning.batlleship.ships.concreteships.Ship;
import com.learning.batlleship.ships.concreteships.TwoDeckShip;
import com.learning.batlleship.ships.fabric.ShipFactory;
import com.learning.batlleship.ships.fabric.TwoDeckShipCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoDeckShipCreatorTest {
    ShipFactory shipFactory;
    Ship[] ships;

    @Before
    public void init() {
        shipFactory = new TwoDeckShipCreator();
        ships = shipFactory.createSetOfShips();
    }

    @Test
    public void testCreateSetOfShips() {
        assertEquals(3, ships.length);
        assertEquals(new TwoDeckShip().toString(), ships[0].toString());
    }
}
