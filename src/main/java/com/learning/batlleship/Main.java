package main.java.com.learning.batlleship;

import main.java.com.learning.batlleship.ships.OneDeckShip;
import main.java.com.learning.batlleship.ships.Ship;
import main.java.com.learning.batlleship.ships.fabric.OneDeckShipCreator;
import main.java.com.learning.batlleship.ships.fabric.ShipFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FieldView fieldView = new FieldView();
        try {
            fieldView.clearFields();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
