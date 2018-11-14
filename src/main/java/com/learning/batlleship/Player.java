package main.java.com.learning.batlleship;

import main.java.com.learning.batlleship.ships.concreteships.Ship;
import main.java.com.learning.batlleship.ships.fabric.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class Player implements Runnable {
    protected char[][] fieldForShips = new char[10][10];
    protected char[][] fieldForShots = new char[10][10];
    protected ArrayList<Ship> listOfShips;

    public Player() {
        listOfShips = createShips();
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

    public void getCoordinatesFromUser(){
        ArrayList<Point> coordinatesList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please insert coordinates:");

        for (int i = 0; i < listOfShips.size(); i++) {
            System.out.println(listOfShips.get(i).toString());
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
        scanner.close();
    }

    public Ship[] getShips() {
        Ship[] ships = new Ship[10];
        listOfShips.toArray(ships);
        return ships;
    }


    @Override
    public void run() {

    }
}
