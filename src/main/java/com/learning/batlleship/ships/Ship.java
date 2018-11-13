package main.java.com.learning.batlleship.ships;

import main.java.com.learning.batlleship.Point;

import java.util.ArrayList;
import java.util.LinkedList;

public interface Ship {
    ArrayList<Point> getCoordinates();

    void setCoordinates(ArrayList<Point> points);

    boolean isHit(Point point);

    boolean isOnWater();
}
