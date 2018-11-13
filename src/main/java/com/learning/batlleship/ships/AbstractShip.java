package main.java.com.learning.batlleship.ships;

import main.java.com.learning.batlleship.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractShip implements Ship {
    protected ArrayList<Point> points;
    protected int lives;

    @Override
    public ArrayList<Point> getCoordinates() {
        return points;
    }

    @Override
    public void setCoordinates(ArrayList<Point> points) {
        this.points = points;
    }

    @Override
    public boolean isHit(Point point) {
        for (int i = 0; i < points.size(); i++) {
            if(points.get(i).equals(point)) {
                points.remove(i);
                lives--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isOnWater() {
        return lives > 0;
    }
}
