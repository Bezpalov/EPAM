package main.java.com.learning.batlleship;

import main.java.com.learning.batlleship.ships.concreteships.Ship;
import main.java.com.learning.batlleship.ships.fabric.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ScheduledExecutorService;

public abstract class Player implements Runnable {
    protected static Scanner scanner;
    protected String name;
    protected static Object mutex = new Object();
    protected char[][] fieldForShips = new char[10][10];
    protected char[][] fieldForShots = new char[10][10];
    protected ArrayList<Ship> listOfShips;
    protected FieldsManipulations fieldsManipulations;
    protected Player anotherPlayer;

    public Player() {
        listOfShips = createShips();
        fieldsManipulations = new FieldsManipulations();
    }

    protected ArrayList<Ship> createShips() {
        ArrayList<Ship> listOfShips = new ArrayList<>();
        ShipFactory[] factories = {new FourDeckShipCreator(), new ThreeDeckShipCreator(),
                new TwoDeckShipCreator(), new OneDeckShipCreator()};

        for (int i = 0; i < factories.length; i++) {
            listOfShips.addAll(Arrays.asList(factories[i].createSetOfShips()));
        }
        return listOfShips;
    }

    public void getCoordinatesFromUser() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please insert coordinates:");
//
//        for (int i = 0; i < listOfShips.size(); i++) {
//            System.out.println(listOfShips.get(i).toString());
//            ArrayList<Point> coordinatesList = new ArrayList<>();
//            for (int j = 0; j < listOfShips.get(i).getLength(); j++) {
//                System.out.println(j + " coordinate: ");
//                int temp = scanner.nextInt();
//                temp = Integer.valueOf(("" + temp).substring(0, 2));
//                int x = temp / 10;
//                int y = temp % 10;
//                coordinatesList.add(new Point(x, y));
//            }
//            listOfShips.get(i).setCoordinates(coordinatesList);
//        }
//        scanner.close();
        ArrayList<Point> fourDeck = new ArrayList<>();
        fourDeck.add(new Point(2, 2));
        fourDeck.add(new Point(2, 3));
        fourDeck.add(new Point(2, 4));
        fourDeck.add(new Point(2, 5));
        listOfShips.get(0).setCoordinates(fourDeck);

    }

    public Ship[] getShips() {
        Ship[] ships = new Ship[10];
        listOfShips.toArray(ships);
        return ships;
    }

    public void getName() {
        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
    }

    public void setAnotherPlayer(Player player) {
        this.anotherPlayer = player;
    }

    private boolean isFleetOnWater() {
        for (Ship s : listOfShips) {
            if (s.isOnWater()) {
                return true;
            }
        }
        return false;
    }

    private Point fromIntToPoint(int i) {
        int temp = Integer.valueOf(("" + i).substring(0, 2));
        int x = temp / 10;
        int y = temp % 10;
        return new Point(x, y);
    }


    @Override
    public void run() {
        scanner = new Scanner(System.in);
        Point coordinate;
        CyclicBarrier barrier = new CyclicBarrier(2);
        synchronized (mutex) {
            getName();
            System.out.println("Hello " + name + "\nPlease select coordinates for your ships");
            getCoordinatesFromUser();
            fieldsManipulations.fillMapWithSetOfShips(getShips(), fieldForShips);
            System.out.println("Your ships is on map");
            fieldsManipulations.showFields(fieldForShips, fieldForShots);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        boolean flag = true;
        synchronized (mutex) {
            while (isFleetOnWater()) {

                while (true) {
                    System.out.println(name + "'s turn, enter coordinate for a hit");
                    coordinate = fromIntToPoint(scanner.nextInt());
                    if (fieldsManipulations.shooting(coordinate, anotherPlayer.fieldForShips,
                            fieldForShots, anotherPlayer.getShips())) {
                        fieldsManipulations.showFields(fieldForShips, fieldForShots);
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
        }
        scanner.close();
    }


}
