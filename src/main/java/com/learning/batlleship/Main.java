package main.java.com.learning.batlleship;

public class Main {
    public static void main(String[] args) {
//        Player player = new Player();
//
//        player.getCoordinatesFromUser();
//        FieldsManipulations manipulations = new FieldsManipulations();
//        manipulations.fillMapWithSetOfShips(player.getShips(),player.fieldForShips);
//        manipulations.showFields(player.fieldForShips, player.fieldForShots);
//        manipulations.shooting(new Point(2,4), player.fieldForShips, player.fieldForShots, player.getShips());
//        manipulations.shooting(new Point(3,6), player.fieldForShips, player.fieldForShots, player.getShips());
//        manipulations.shooting(new Point(9,7), player.fieldForShips, player.fieldForShots, player.getShips());
//        manipulations.showFields(player.fieldForShips, player.fieldForShots);

        Player player1 = new User();
        Player player2 = new User();
        player1.setAnotherPlayer(player2);
        player2.setAnotherPlayer(player1);

        Thread threa1 = new Thread(player1);
        Thread thread2 = new Thread(player2);
        threa1.start();
        thread2.start();
    }

}
