package com.learning.battleship.ships.fabric;

import com.learning.batlleship.ships.concreteships.Ship;
import com.learning.batlleship.ships.concreteships.ThreeDeckShip;
import com.learning.batlleship.ships.fabric.ShipFactory;
import com.learning.batlleship.ships.fabric.ThreeDeckShipCreator;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeDeckShipTest {
    ShipFactory shipFactory;
    Ship[] ships;

    @Before
    public void init() {
        shipFactory = new ThreeDeckShipCreator();
        ships = shipFactory.createSetOfShips();
    }

    @Test
    public void testCreateSetOfShips() {
        assertEquals(2, ships.length);
        assertEquals(new ThreeDeckShip().toString(), ships[0].toString());
    }
}
