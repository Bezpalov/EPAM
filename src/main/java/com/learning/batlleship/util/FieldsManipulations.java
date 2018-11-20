package com.learning.batlleship.util;

import com.learning.batlleship.ships.concreteships.Ship;

import java.util.ArrayList;

/**
 * Class for actions with fields
 */
public class FieldsManipulations {

    /**
     * Method fills the map of a player with a single ship
     *
     * @param ship Ship object that coordinates are using for draw the ship on map
     * @param map  field for draw the ship
     * @return String representation of what kind of coordinates was used
     * (if coordinates are wrong or don't put in map)
     */
    private String fillMapWithShip(Ship ship, char[][] map) {
        if (ship == null) {
            throw new IllegalArgumentException("ship must exists");
        } else if (map == null) {
            throw new IllegalArgumentException("map must exists");
        }
        ArrayList<Point> coordinates = ship.getCoordinates();
        String result;

        if (checkOnCapacity(coordinates, map) && checkOnBoarders(coordinates, map)) {
            for (Point p : coordinates) {
                map[p.getX()][p.getY()] = 'X';
            }
            result = "The" + ship.getClass().getName() + "is successfully located on the map";
        } else {
            result = "random ship has created";
            randomShipLocating(ship, map);
        }
        return result;
    }

    /**
     * Method fills the map of a player with standard set
     * of ships (method use a fillWithMapShip in  a cycle)
     *
     * @param ships array of ships
     * @param map   field for draw ships
     * @return String representation of what kind of
     */
    public String fillMapWithSetOfShips(Ship[] ships, char[][] map) {
        if (ships == null) {
            throw new IllegalArgumentException("ships must exist");
        } else if (map == null) {
            throw new IllegalArgumentException("map must exists");
        }
        StringBuilder result = new StringBuilder();

        for (Ship ship : ships) {
            result.append(fillMapWithShip(ship, map)).append("\n");
        }
        return result.toString();
    }

    /**
     * Method for random locating ship on the map
     *
     * @param ship Ship object that need to be located on a map
     * @param map  field for ship
     */
    public void randomShipLocating(Ship ship, char[][] map) {
        if (ship == null) {
            throw new IllegalArgumentException("ship must exist");
        } else if (map == null) {
            throw new IllegalArgumentException("map must exists");
        }
        int x;
        int y;
        boolean isFound = false;
        ArrayList<Point> points = null;

        while (!isFound) {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);

            points = new ArrayList<>(ship.getLength());
            int direction = (int) Math.round(Math.random() * 3);

            switch (direction) {
                case 0:
                    for (int i = x; i < ship.getLength() + x; i++) {
                        points.add(new Point(i, y));
                    }
                    break;
                case 1:
                    for (int i = y; i < ship.getLength() + y; i++) {
                        points.add(new Point(x, i));
                    }
                    break;
                case 2:
                    for (int i = x; i > x - ship.getLength(); i--) {
                        points.add(new Point(i, y));
                    }
                    break;
                case 3:
                    for (int i = y; i > y - ship.getLength(); i--) {
                        points.add(new Point(x, i));
                    }
                    break;
            }
            if (checkOnPositive(points)
                    && checkOnCapacity(points, map)
                    && checkOnBoarders(points, map)) {
                isFound = true;
            }
        }
        ship.setCoordinates(points);
        fillMapWithShip(ship, map);
    }

    /**
     * Method for checking ArrayList of Point objects on
     * positive values of coordinates
     *
     * @param points ArrayList with Point object inside
     * @return true - if all coordinate are positive (including 0)
     * false - if even one number will be negative
     */
    private boolean checkOnPositive(ArrayList<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException("points must exists");
        }
        int x;
        int y;

        for (Point p : points) {
            x = p.getX();
            y = p.getY();
            if (x < 0 || y < 0 || x > 9 || y > 9) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method that checks if a future ship will collide with ships
     * already existing on map
     *
     * @param coordinates coordinates of a future ship
     * @param map         field with ships
     * @return true - if a future ship fit into map without collide with
     * existing ships
     * false - if a future ship will collide with  already existing ships
     */
    private boolean checkOnCapacity(ArrayList<Point> coordinates, char[][] map) {
        if (coordinates == null) {
            throw new IllegalArgumentException("coordinates must exists");
        } else if (map == null) {
            throw new IllegalArgumentException("map must exists");
        }
        for (Point p : coordinates) {
            if (map[p.getX()][p.getY()] == 'X') {
                return false;
            }
        }
        return true;
    }

    /**
     * Method for checking if future ship will stand on map with right offset
     * (minimum one square offset)
     *
     * @param coordinates coordinates of a future ship
     * @param map         field with ships
     * @return true - if a future ship will fit into map with offset
     * false - if a future ship will not fit into map with offset
     */
    private boolean checkOnBoarders(ArrayList<Point> coordinates, char[][] map) {
        if (coordinates == null) {
            throw new IllegalArgumentException("coordinates must exists");
        } else if (map == null) {
            throw new IllegalArgumentException("map must exists");
        }
        int x;
        int y;

        for (Point p : coordinates) {
            x = p.getX();
            y = p.getY();
            for (int i = x - 1; i <= x + 1; i++) {
                if (i < 0 || i > 9) {
                    continue;
                }
                for (int j = y - 1; j <= y + 1; j++) {
                    if (j < 0 || j > 9) {
                        continue;
                    } else if (map[i][j] == 'X') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Method that shows field of player ships and field of players shots
     *
     * @param shipsMap field of player ships
     * @param shotsMap field of player shots
     */
    public void showFields(char[][] shipsMap, char[][] shotsMap) {
        if (shipsMap == null) {
            throw new IllegalArgumentException("shipMap must exists");
        } else if (shotsMap == null) {
            throw new IllegalArgumentException("shotsMap must exists");
        }
        StringBuilder line = new StringBuilder("  0 1 2 3 4 5 6 7 8 9").append("    ")
                .append("  0 1 2 3 4 5 6 7 8 9").append("\n");

        for (int i = 0; i < shipsMap[0].length; i++) {
            line.append(i).append(" ");
            for (int j = 0; j < shipsMap[i].length; j++) {
                if (shipsMap[j][i] != '\u0000') {
                    line.append(shipsMap[j][i]).append(" ");
                } else {
                    line.append("  ");
                }
            }
            line.append("   ").append(i).append(" ");
            for (int j = 0; j < shotsMap[i].length; j++) {
                if (!Character.isLetter(shotsMap[j][i])) {
                    line.append("  ");
                } else {
                    line.append(shotsMap[j][i]).append(" ");
                }

            }
            line.append("\n");
        }
        System.out.println(line);
    }

    /**
     * Method that execute a shooting
     *
     * @param coordinate         coordinates of a shot
     * @param anotherPlayerField field of opponent ships for checking a shot
     * @param fieldForShots      field for player shots
     * @param anotherPlayerShips opponent ships for subtract lives from ships
     * @return true - if someone ship was hit
     * false - if no one ship was hit
     */
    public boolean shooting(Point coordinate, char[][] anotherPlayerField, char[][] fieldForShots, Ship[] anotherPlayerShips) {
        if (coordinate == null) {
            throw new IllegalArgumentException("coordinate must exists");
        } else if (anotherPlayerField == null) {
            throw new IllegalArgumentException("anotherPlayerField must exists");
        } else if (fieldForShots == null) {
            throw new IllegalArgumentException("fieldForShots must exists");
        } else if (anotherPlayerField == null) {
            throw new IllegalArgumentException("anotherPlayerShips must exists");
        }
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (searchOnHit(x, y, anotherPlayerField)) {
            Ship hittedShip = searchAShip(anotherPlayerShips, coordinate);
            if (!hittedShip.isOnWater()) {
                System.out.println(hittedShip.toString() + " is destroyed");
                getBordersAroundShip(hittedShip, fieldForShots);
            }
            gotHitted(fieldForShots, anotherPlayerField, coordinate, true);
            return true;
        }
        gotHitted(fieldForShots, anotherPlayerField, coordinate, false);
        return false;
    }

    /**
     * draw a misses around "dead" ship
     *
     * @param hittedShip    "dead" ship
     * @param fieldForShots field which ship will be drawn in
     */
    private void getBordersAroundShip(Ship hittedShip, char[][] fieldForShots) {
        if (hittedShip == null) {
            throw new IllegalArgumentException("hittedShip must exists");
        } else if (fieldForShots == null) {
            throw new IllegalArgumentException("fieldForShots must exists");
        }
        int x;
        int y;

        for (Point p : hittedShip.getCoordinates()) {
            x = p.getX();
            y = p.getY();
            for (int i = x - 1; i <= x + 1; i++) {
                if (i < 0 || i > 9) {
                    continue;
                }
                for (int j = y - 1; j <= y + 1; j++) {
                    if (j < 0 || j > 9) {
                        continue;
                    } else if (fieldForShots[i][j] == '\u0000') {
                        fieldForShots[i][j] = 'M';
                    }
                }
            }
        }
    }

    /**
     * Method for mapping hit a ship
     *
     * @param fieldForShots field for map changing after shot
     * @param fieldForShips field for map changing after shot
     * @param coordinate    coordinate of a shot
     * @param flag          true - shot was hit the target
     *                      false - shot was missed
     */
    private void gotHitted(char[][] fieldForShots, char[][] fieldForShips, Point coordinate, boolean flag) {
        if (fieldForShots == null) {
            throw new IllegalArgumentException("fieldForShots must exists");
        } else if (fieldForShips == null) {
            throw new IllegalArgumentException("fieldForShips must exists");
        } else if (coordinate == null) {
            throw new IllegalArgumentException("coordinate must exists");
        }
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (flag) {
            fieldForShots[x][y] = 'O';
            fieldForShips[x][y] = 'O';
        } else {
            if (fieldForShots[x][y] == 'O') {
                return;
            }
            fieldForShots[x][y] = 'M';
            fieldForShips[x][y] = 'M';
        }
    }

    /**
     * Method looking for a ship with equal coordinate
     *
     * @param ships      set of ships for searching
     * @param coordinate coordinate of a shot
     * @return Ship object with coordinate equal shot coordinate
     */
    private Ship searchAShip(Ship[] ships, Point coordinate) {
        if (ships == null) {
            throw new IllegalArgumentException("ships must exists");
        } else if (coordinate == null) {
            throw new IllegalArgumentException("coordinate must exists");
        }

        for (Ship ship : ships) {
            if (ship.isHit(coordinate)) {
                return ship;
            }
        }
        throw new IllegalArgumentException("Unexpected error in searchAShip");
    }

    /**
     * Method checks if coordinates points on square in field with 'X'
     *
     * @param x     first part of coordinate
     * @param y     second part of coordinate
     * @param field field for checking
     * @return true - if pointed coordinate on a field content
     * part of a ship ('X')
     * false - if pointed coordinate on a field content
     * something else but not part of a ship ('X')
     */
    private boolean searchOnHit(int x, int y, char[][] field) {
        return field[x][y] == 'X';
    }
}
