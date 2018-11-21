package com.learning.battleship.ships.concreteships;

import com.learning.batlleship.ships.concreteships.AbstractShip;
import com.learning.batlleship.util.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AbstractShipTest extends AbstractShip {


    @Before
    public void init() {
        List<Point> newPoint = Arrays.asList(new Point (1, 1), new Point(1, 2));
        points = newPoint;
        lives = 1;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCoordinates () {
        setCoordinates(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testIsHitException () {
        isHit(null);
    }

    @Test
    public void testIsHit() {
        assertTrue(isHit(new Point(1, 1)));
        assertFalse(isHit(new Point(1, 3)));
    }

    @Test
    public void testIsOnWater() {
        assertTrue (isOnWater());
        lives = 0;
        assertFalse(isOnWater());
    }



}
