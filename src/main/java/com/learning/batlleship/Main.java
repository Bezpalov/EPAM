package main.java.com.learning.batlleship;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();


        player.getCoordinatesFromUser();
        FieldsManipulations manipulations = new FieldsManipulations();
        manipulations.fillMapWithSetOfShips(player.getShips(),player.fieldForShips);
        manipulations.showFields(player.fieldForShips);
    }

}
