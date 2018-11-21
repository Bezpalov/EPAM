package com.learning.battleship.players;

import com.learning.batlleship.players.Player;
import com.learning.batlleship.players.User;
import com.learning.batlleship.ships.concreteships.*;
import com.learning.batlleship.util.Point;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest extends Player {
    private User user;
    private Class c;
    private Method method;
    private char[][] charArray;


    @Before
    public void init() {
        user = new User();
        c = user.getClass();
        charArray = new char[10][10];
    }

    @Test
    public void testCreateShips() {
        ArrayList<Ship> ships = null;

        try {
            method = c.getDeclaredMethod("createShips");
            method.setAccessible(true);
            ships = (ArrayList<Ship>) method.invoke(user);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        assertEquals(10, ships.size());
        assertEquals(ships.get(0).toString(), new FourDeckShip().toString());
        assertEquals(ships.get(1).toString(), new ThreeDeckShip().toString());
        assertEquals(ships.get(3).toString(), new TwoDeckShip().toString());
        assertEquals(ships.get(6).toString(), new OneDeckShip().toString());
    }

    @Test
    public void testGetShips() {
        Ship[] ships = null;

        try {
            method = c.getDeclaredMethod("getShips");
            method.setAccessible(true);
            ships = (Ship[]) method.invoke(user);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        assertEquals(10, ships.length);
        assertEquals(ships[0].toString(), new FourDeckShip().toString());
        assertEquals(ships[1].toString(), new ThreeDeckShip().toString());
        assertEquals(ships[3].toString(), new TwoDeckShip().toString());
        assertEquals(ships[6].toString(), new OneDeckShip().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetAnotherPlayerException() {
        user.setAnotherPlayer(null);
    }

    @Test
    public void testIsFleetOnWater() {
        assertTrue(isFleetOnWater());
        for (Ship s : listOfShips) {
            fieldsManipulations.randomShipLocating(s, charArray);
        }
        List<Point> points;
        for (Ship s : listOfShips) {
            points = s.getCoordinates();
            for (Point p : points) {
                s.isHit(p);
            }
        }
        assertFalse(isFleetOnWater());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromIntToPointException() {
        fromIntToPoint(null);
    }

    @Test
    public void testFromIntToPoint() {
        assertEquals(new Point(1,2), fromIntToPoint("12"));
        assertEquals(new Point(7,9), fromIntToPoint("79sdf"));
    }

}
