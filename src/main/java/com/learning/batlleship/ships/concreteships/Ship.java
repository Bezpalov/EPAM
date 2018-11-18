package com.learning.batlleship.ships.concreteships;

import com.learning.batlleship.util.Point;

import java.util.ArrayList;

public interface Ship {
    ArrayList<Point> getCoordinates();

    void setCoordinates(ArrayList<Point> points);

    boolean isHit(Point point);

    boolean isOnWater();

    int getLives();

    int getLength();
}
