package main.java.com.learning.batlleship;

import main.java.com.learning.batlleship.ships.concreteships.Ship;

import java.io.IOException;
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
            result = randomShipLocating(ship, map);
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

    private String randomShipLocating(Ship ship, char[][] map) {
        int x;
        int y;
        boolean isFound = false;
        String message = "unpredictable problem in randomShipLocating";

        while (!isFound) {
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            if (map[x][y] == ' ') {
                ArrayList<Point> points = new ArrayList<>(ship.getLength());
                int side = (int) Math.abs(Math.random());

                switch (side) {
                    case 0:
                        for (int i = x; i < ship.getLength(); i++) {
                            points.add(new Point(i, y));
                        }
                        break;
                    case 1:
                        for (int i = y; i < ship.getLength(); i++) {
                            points.add(new Point(x, i));
                        }
                        break;
                }
                if (checkOnCapacity(points, map) && checkOnBoarders(points, map)) {
                    message = "new location for ship has been done";
                    isFound = true;
                }
            }
        }
        return message;
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
                for (int j = y - 1; j < y + 1; j++) {
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

    public void showFields(char[][] chars) {

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < chars[0].length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                line.append(chars[i][j]);
            }
            line.append("\n");
        }
        System.out.println(line);
    }

    public boolean shooting(Point coordinate, char[][] field) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        if (search(x, y, field)) {
            return true;
        }
        return false;
    }

    private boolean search(int x, int y, char[][] field) {
        if (field[x][y] == 'X') {
            field[x][y] = 'O';
            return true;
        }
        return false;
    }
}
