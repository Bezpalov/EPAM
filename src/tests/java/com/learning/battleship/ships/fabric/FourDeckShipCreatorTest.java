package com.learning.battleship.ships.fabric;

import com.learning.batlleship.ships.concreteships.FourDeckShip;
import com.learning.batlleship.ships.concreteships.Ship;
import com.learning.batlleship.ships.fabric.FourDeckShipCreator;
import com.learning.batlleship.ships.fabric.ShipFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FourDeckShipCreatorTest {
    ShipFactory shipFactory;
    Ship[] ships;

    @Before
    public void init() {
        shipFactory = new FourDeckShipCreator();
        ships = shipFactory.createSetOfShips();
    }

    @Test
    public void testCreateSetOfShips() {
        assertEquals(1, ships.length);
        assertEquals(new FourDeckShip().toString(), ships[0].toString());
    }
}
