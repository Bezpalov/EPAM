package com.learning.batlleship.players;

import com.learning.batlleship.util.FieldsManipulations;
import com.learning.batlleship.util.Point;
import com.learning.batlleship.ships.concreteships.Ship;
import com.learning.batlleship.ships.fabric.*;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Abstract class that represents a player.
 * There is opportunity to play versus another human
 * or dump realization of pc
 */
public abstract class Player implements Runnable {
    protected static CyclicBarrier barrier = new CyclicBarrier(2);
    public static Scanner scanner;
    protected String name;
    protected static final Object mutex = new Object();
    protected char[][] fieldForShips = new char[10][10];
    protected char[][] fieldForShots = new char[10][10];
    protected ArrayList<Ship> listOfShips;
    protected FieldsManipulations fieldsManipulations;
    protected Player anotherPlayer;

    public Player() {
        listOfShips = createShips();
        fieldsManipulations = new FieldsManipulations();
    }

    /**
     * Method for creating a standard set of ships:
     * one four deck, two three deck, three two deck
     * and four one deck ships
     *
     * @return List with ships from ship factory
     */
    protected ArrayList<Ship> createShips() {
        ArrayList<Ship> listOfShips = new ArrayList<>();
        ShipFactory[] factories = {new FourDeckShipCreator(), new ThreeDeckShipCreator(),
                new TwoDeckShipCreator(), new OneDeckShipCreator()};

        for (int i = 0; i < factories.length; i++) {
            listOfShips.addAll(Arrays.asList(factories[i].createSetOfShips()));
        }
        return listOfShips;
    }

    /**
     * Method for taking a coordinates from user.
     * Data takes from console, System.in thread
     * Coordinates are added to ships respectively
     */
    public void getCoordinatesFromUser() {
        scanner = new Scanner(System.in);
        System.out.println("Please insert coordinates:");

        for (int i = 0; i < listOfShips.size(); i++) {
            System.out.println(listOfShips.get(i).toString());
            ArrayList<Point> coordinatesList = new ArrayList<>();
            for (int j = 0; j < listOfShips.get(i).getLength(); j++) {
                System.out.println(j + " coordinate: ");
                int temp = scanner.nextInt();
                temp = Integer.valueOf(("" + temp).substring(0, 2));
                int x = temp / 10;
                int y = temp % 10;
                coordinatesList.add(new Point(x, y));
            }
            listOfShips.get(i).setCoordinates(coordinatesList);
        }
    }

    /**
     * Method gives a set of ships in array
     *
     * @return array of ships of a player
     */
    protected Ship[] getShips() {
        Ship[] ships = new Ship[10];
        listOfShips.toArray(ships);
        return ships;
    }

    /**
     * Method asks user name and
     * connecting it to name variable
     */
    protected void getName() {
        System.out.println("Enter your name:");
        scanner = new Scanner(System.in);
        name = scanner.nextLine();
    }

    /**
     * Method get opponents Player object for possibility
     * to change values in it
     *
     * @param player opponents object
     */
    public void setAnotherPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("There is no Player object here");
        }
        this.anotherPlayer = player;
    }

    /**
     * Check if "fleet" (set of ships) has lives or doesn't have
     *
     * @return answer in boolean form
     */
    protected boolean isFleetOnWater() {
        for (Ship s : listOfShips) {
            if (s.isOnWater()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method transform input from user in String format
     * to Point object with coordinates
     *
     * @param input String from user
     * @return Point object that represent a coordinates
     */
    private Point fromIntToPoint(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input must be non null");
        }
        int temp = Integer.valueOf(input.substring(0, 2));
        int x = temp / 10;
        int y = temp % 10;
        return new Point(x, y);
    }


    /**
     * Main part of program with bulk of work
     */
    @Override
    public void run() {
        //Initialization part of a game
        scanner = new Scanner(System.in);
        Point coordinate;
        synchronized (mutex) {
            getName();
            System.out.println("Hello " + name + "\nPlease select coordinates for your ships");
            getCoordinatesFromUser();
            fieldsManipulations.fillMapWithSetOfShips(getShips(), fieldForShips);
            System.out.println("Your ships is on map");
        }

        //wait until another thread is finish initialization part
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


        while (isFleetOnWater()) {
            synchronized (mutex) {
                mutex.notify();
                try {
                    mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true) {
                    fieldsManipulations.showFields(fieldForShips, fieldForShots);
                    System.out.println(name + "'s turn, enter coordinate for a hit");
                    coordinate = fromIntToPoint(scanner.nextLine());

                    // equal shot check, if the shot is equal the existing one it tells about that
                    // and asks for another coordinates
                    if (checkOnRepeat(fieldForShots, coordinate)) {
                        System.out.println("This coordinates have already been chosen\n" +
                                "please try another ones");
                        Point nextShot;
                        do {
                            nextShot = fromIntToPoint(scanner.nextLine());
                        } while (nextShot.equals(coordinate));
                        coordinate = nextShot;
                    }

                    if (fieldsManipulations.shooting(coordinate, anotherPlayer.fieldForShips,
                            fieldForShots, anotherPlayer.getShips())) {
                        System.out.println("Hit!!!11");
                        //condition of the termination
                        if (!anotherPlayer.isFleetOnWater()) {
                            System.out.println(name + " has won");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Miss!\n");
                        break;
                    }
                }
            }
        }
        System.out.println(name + "have lost");
        scanner.close();
        System.exit(0);
    }

    /**
     * Equals coordinate check method
     *
     * @param fieldForShots 2 dimensional array that represent a field for
     *                      user shots
     * @param coordinate    new coordinate that should be checked
     * @return true - if new coordinate equal to another one, existing in a field
     * false - if new coordinate doesn't equal another one
     */
    protected boolean checkOnRepeat(char[][] fieldForShots, Point coordinate) {
        if (coordinate == null) {
            throw new IllegalArgumentException("Coordinate must exists");
        } else if (fieldForShots == null) {
            throw new IllegalArgumentException("fieldForShots must exists");
        }
        int x = coordinate.getX();
        int y = coordinate.getY();
        char temp = fieldForShots[x][y];
        if (temp == 'M' || temp == 'O') {
            return true;
        }
        return false;
    }
}
