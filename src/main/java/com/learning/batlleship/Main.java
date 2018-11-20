package com.learning.batlleship;

import com.learning.batlleship.players.PC;
import com.learning.batlleship.players.Player;
import com.learning.batlleship.players.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       new Main().letsStart();



    }

    public void letsStart(){
        Player.scanner = new Scanner(System.in);
        System.out.println("Hello, this is a battleship game");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Please select a game mode:" +
                            "\n 1) versus PC (type: PC)" +
                            "\n 2) versus another player (type: Player)");
        String answer = Player.scanner.nextLine();

        switch (answer.toUpperCase()) {
            case "PC":
                PC pc = new PC();
                User user = new User();
                pc.setAnotherPlayer(user);
                user.setAnotherPlayer(pc);

                new Thread(pc).start();
                new Thread(user).start();

                break;
            case "PLAYER":
                User user1 = new User();
                User user2 = new User();
                user1.setAnotherPlayer(user2);
                user2.setAnotherPlayer(user1);

                new Thread(user1).start();
                new Thread(user2).start();
                break;
        }

    }

}
