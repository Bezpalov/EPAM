package com.learning.battleship.ships.fabric;

import com.learning.batlleship.ships.concreteships.OneDeckShip;
import com.learning.batlleship.ships.concreteships.Ship;
import com.learning.batlleship.ships.concreteships.TwoDeckShip;
import com.learning.batlleship.ships.fabric.OneDeckShipCreator;
import com.learning.batlleship.ships.fabric.ShipFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OneDeckShipCreatorTest {
    ShipFactory shipFactory;
    Ship[] ships;

    @Before
    public void init() {
        shipFactory = new OneDeckShipCreator();
        ships = shipFactory.createSetOfShips();
    }

    @Test
    public void testCreateSetOfShips() {
        assertEquals(4, ships.length);
        assertEquals(new OneDeckShip().toString(), ships[0].toString());
    }
}
