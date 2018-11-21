package com.learning.battleship.util;

import com.learning.batlleship.ships.concreteships.FourDeckShip;
import com.learning.batlleship.ships.concreteships.OneDeckShip;
import com.learning.batlleship.ships.concreteships.Ship;
import com.learning.batlleship.util.FieldsManipulations;
import com.learning.batlleship.util.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FieldManipulationsTest {
    char[][] map;
    FieldsManipulations fieldsManipulations;
    char[][] anotherPlayerField;
    char[][] playerField;
    Ship[] ships = {new OneDeckShip(), new OneDeckShip()};


    @Before
    public void init() {
        map = new char[10][10];
        fieldsManipulations = new FieldsManipulations();
        anotherPlayerField = new char[10][10];
        playerField = new char[10][10];
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFillMapWithShipExceptionShip() {
        fieldsManipulations.fillMapWithShip(null, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFillMapWithShipExceptionMap() {
        fieldsManipulations.fillMapWithShip(new FourDeckShip(), null);
    }

    @Test
    public void testFillMapWithShip() {
        Ship firstShip = new OneDeckShip();
        Ship secondShip = new OneDeckShip();
        firstShip.setCoordinates(Arrays.asList(new Point(1, 1)));
        secondShip.setCoordinates(Arrays.asList(new Point(1, 1)));

        assertEquals("The" + firstShip.getClass().getName() + "is successfully located on the map",
                fieldsManipulations.fillMapWithShip(firstShip, map));
        assertEquals("random ship has created",
                fieldsManipulations.fillMapWithShip(secondShip, map));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFillMapWithSetOFShipExceptionShip() {
        fieldsManipulations.fillMapWithSetOfShips(null, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFillMapWithSetOfShipExceptionMap() {
        fieldsManipulations.fillMapWithSetOfShips(new Ship[1], null);
    }

    @Test
    public void testFillMapWithSetOfShips() {
        Ship[] ships = {new OneDeckShip()};
        ships[0].setCoordinates(Arrays.asList(new Point(1, 1)));
        assertEquals("The" + ships[0].getClass().getName() + "is successfully located on the map\n",
                fieldsManipulations.fillMapWithSetOfShips(ships, map));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandomShipLocationExceptionShip() {
        fieldsManipulations.randomShipLocating(null, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandomShipLocationExceptionMap() {
        fieldsManipulations.randomShipLocating(new OneDeckShip(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckOnPositiveException() {
        fieldsManipulations.checkOnPositive(null);
    }

    @Test
    public void testCheckOnPositive() {
        List<Point> positive = Arrays.asList(new Point(0, 0), new Point(4, 9), new Point(8, 1));
        List<Point> negative = Arrays.asList(new Point(0, 0), new Point(-4, 9), new Point(8, -1));

        assertTrue(fieldsManipulations.checkOnPositive(positive));
        assertFalse(fieldsManipulations.checkOnPositive(negative));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckOnCapacityExceptionCoordinates() {
        fieldsManipulations.checkOnCapacity(null, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckOnCapacityExceptionMap() {
        fieldsManipulations.checkOnCapacity(Arrays.asList(new Point(0, 0)), null);
    }

    @Test
    public void testCheckOnCapacity() {
        map[0][0] = 'X';
        map[9][5] = 'X';
        map[4][8] = 'F';

        List firstList = Arrays.asList(new Point(0, 0), new Point(9, 5));
        List secondList = Arrays.asList(new Point(4, 8));

        assertFalse(fieldsManipulations.checkOnCapacity(firstList, map));
        assertTrue(fieldsManipulations.checkOnCapacity(secondList, map));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckOnBoardersExceptionCoordinates() {
        fieldsManipulations.checkOnBoarders(null, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckOnBoardersExceptionMap() {
        fieldsManipulations.checkOnBoarders(Arrays.asList(new Point(0, 0)), null);
    }

    @Test
    public void testCheckOnBoarders() {
        map[0][0] = 'X';
        map[9][5] = 'X';

        List<Point> falseList = Arrays.asList(new Point(0, 1));
        List<Point> trueList = Arrays.asList(new Point(5, 5));
        assertFalse(fieldsManipulations.checkOnBoarders(falseList, map));
        assertTrue(fieldsManipulations.checkOnBoarders(trueList, map));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShowFieldsExceptionShipMap() {
        fieldsManipulations.showFields(null, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShowFieldsExceptionShotMap() {
        fieldsManipulations.showFields(map, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShootingExceptionCoordinate() {
        fieldsManipulations.shooting(null, new char[10][10], new char[10][10], new Ship[1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShootingExceptionAnotherField() {
        fieldsManipulations.shooting(new Point(0, 1), null, new char[10][10], new Ship[1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShootingExceptionfield() {
        fieldsManipulations.shooting(new Point(0, 1), new char[10][10], null, new Ship[1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShootingExceptionShip() {
        fieldsManipulations.shooting(new Point(0, 1), new char[10][10], null, new Ship[1]);
    }

    @Test
    public void testShooting() {
        char[][] anotherPlayerField = new char[10][10];
        char[][] playerField = new char[10][10];
        Ship[] ships = {new OneDeckShip(), new OneDeckShip()};

        ships[0].setCoordinates(Arrays.asList(new Point(0, 0)));
        ships[1].setCoordinates(Arrays.asList(new Point(5, 5)));
        anotherPlayerField[0][0] = 'X';
        anotherPlayerField[5][5] = 'X';

        assertTrue(fieldsManipulations.shooting(new Point(0, 0), anotherPlayerField, playerField, ships));
        assertTrue(fieldsManipulations.shooting(new Point(5, 5), anotherPlayerField, playerField, ships));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBordersAroundShipExceptionShip() {
        fieldsManipulations.getBordersAroundShip(null, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBordersAroundShipExceptionField() {
        fieldsManipulations.getBordersAroundShip(new OneDeckShip(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGotHittedExceptionFieldForShots() {
        fieldsManipulations.gotHitted(null, playerField, new Point(0, 0), true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGotHittedExceptionFieldForShips() {
        fieldsManipulations.gotHitted(playerField, null, new Point(0, 0), true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGotHittedExceptionCoordinate() {
        fieldsManipulations.gotHitted(playerField, playerField, null, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchAShipExceptionShip() {
        fieldsManipulations.searchAShip(null, new Point(0, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchAShipExceptionCoordinate() {
        fieldsManipulations.searchAShip(ships, null);
    }

    @Test
    public void testSearchOnHit() {
        map[0][0] = 'X';
        map[9][5] = 'X';

        assertTrue(fieldsManipulations.searchOnHit(0, 0, map));
        assertTrue(fieldsManipulations.searchOnHit(9, 5, map));
        assertFalse(fieldsManipulations.searchOnHit(6, 8, map));
    }
}
