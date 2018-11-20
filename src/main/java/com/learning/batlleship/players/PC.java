package com.learning.batlleship.players;

import com.learning.batlleship.util.Point;

import java.util.concurrent.BrokenBarrierException;

public class PC extends Player {

    @Override
    public void run() {
        Point coordinate;
        synchronized (mutex) {
            name = "PC";
            for (int i = 0; i < listOfShips.size(); i++) {
                fieldsManipulations.randomShipLocating(listOfShips.get(i), fieldForShips);
            }
            System.out.println("PC ships is on map");
        }

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

                boolean isRepeat = false;
                Point previousShot = null;
                while (true) {
                    System.out.println(name + "'s turn");
                    coordinate = getRandomShot(isRepeat, previousShot);
                    System.out.println("PC choose a " + coordinate.getX() + coordinate.getY() + " to shot");
                    if (fieldsManipulations.shooting(coordinate, anotherPlayer.fieldForShips,
                            fieldForShots, anotherPlayer.getShips())) {
                        System.out.println("Hit!!!11");
                        fieldsManipulations.showFields(fieldForShips, fieldForShots);
                        isRepeat = true;
                        previousShot = coordinate;
                        if (!anotherPlayer.isFleetOnWater()) {
                            System.out.println(name + " has won");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Miss!");
                        break;
                    }
                }
            }
        }
        System.out.println(name + "have lost");
        scanner.close();
        System.exit(0);
    }

    private Point getRandomShot(boolean isRepeat, Point previous) {
        int x = (int) Math.round(Math.random() * 9);
        int y = (int) Math.round(Math.random() * 9);

        if (isRepeat) {
            int previousX = previous.getX();
            int previousY = previous.getY();
            int side = Math.round((int) Math.random() * 3);

            switch (side) {
                case 0:
                    x = previousX;
                    y = previousY - 1;
                    break;
                case 1:
                    x = previousX + 1;
                    y = previousY;
                    break;
                case 2:
                    x = previousX;
                    y = previousY + 1;
                    break;
                case 3:
                    x = previousX - 1;
                    y = previousY;
                    break;
            }
        }
        return new Point(x, y);
    }
}
