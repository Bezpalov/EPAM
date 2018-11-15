package main.java.com.learning.batlleship;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        player.getCoordinatesFromUser();
        FieldsManipulations manipulations = new FieldsManipulations();
        manipulations.fillMapWithSetOfShips(player.getShips(),player.fieldForShips);
        manipulations.showFields(player.fieldForShips, player.fieldForShots);
        manipulations.shooting(new Point(2,4), player.fieldForShips, player.fieldForShots, player.getShips());
        manipulations.shooting(new Point(3,6), player.fieldForShips, player.fieldForShots, player.getShips());
        manipulations.shooting(new Point(9,7), player.fieldForShips, player.fieldForShots, player.getShips());
        manipulations.showFields(player.fieldForShips, player.fieldForShots);
    }

}
