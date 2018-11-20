package com.learning.batlleship.util;

import com.learning.batlleship.ships.concreteships.Ship;

import java.util.ArrayList;

public class FieldsManipulations {

    public String fillMapWithShip(Ship ship, char[][] map) {
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

    public String fillMapWithSetOfShips(Ship[] ships, char[][] map) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < ships.length; i++) {
            result.append(fillMapWithShip(ships[i], map)).append("\n");
        }
        return result.toString();
    }

    public void randomShipLocating(Ship ship, char[][] map) {
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

    private boolean checkOnPositive(ArrayList<Point> points) {
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

    private boolean checkOnDistance(ArrayList<Point> points, char[][] map) {
        return true;
    }

    private boolean checkOnOutOfRange(int x, int y, Ship ship) {
        int length = ship.getLength();
        return (x + length < 10 && x - length >= 0 &&
                y + length < 10 && y - length >= 0);
    }

    private boolean checkOnCapacity(ArrayList<Point> coordinates, char[][] map) {
        for (Point p : coordinates) {
            if (map[p.getX()][p.getY()] == 'X') {
                return false;
            }
        }
        return true;
    }

    private boolean checkOnBoarders(ArrayList<Point> coordinates, char[][] map) {
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

    public void showFields(char[][] shipsMap, char[][] shotsMap) {

        StringBuilder line = new StringBuilder("  0 1 2 3 4 5 6 7 8 9").append("    ")
                .append("  0 1 2 3 4 5 6 7 8 9").append("\n");
        for (int i = 0; i < shipsMap[0].length; i++) {
            line.append(i).append(" ");
            for (int j = 0; j < shipsMap[i].length; j++) {
                if (shipsMap[j][i] == 'X' || shipsMap[j][i] == 'O') {
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

    public boolean shooting(Point coordinate, char[][] AnotherPlayerField, char[][] fieldForShots, Ship[] AnotherPlayerShips) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        if (searchOnHit(x, y, AnotherPlayerField)) {
            searchAShip(AnotherPlayerShips, coordinate);
            gotHitted(fieldForShots, AnotherPlayerField, coordinate, true);
            return true;
        }
        gotHitted(fieldForShots, AnotherPlayerField, coordinate, false);
        return false;
    }

    private void gotHitted(char[][] fieldForShots, char[][] fieldForShips, Point coordinate, boolean flag) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        if (flag) {
            fieldForShots[x][y] = 'O';
            fieldForShips[x][y] = 'O';
        } else {
            fieldForShips[x][y] = 'M';
            fieldForShots[x][y] = 'M';
        }
    }

    private Ship searchAShip(Ship[] ships, Point coordinate) {
        for (int i = 0; i < ships.length; i++) {
            if (ships[i].isHit(coordinate)) {
                return ships[i];
            }
        }
        throw new IllegalArgumentException("Unexpected error in searchAShip");
    }

    private boolean searchOnHit(int x, int y, char[][] field) {
        return field[x][y] == 'X';
    }
}
