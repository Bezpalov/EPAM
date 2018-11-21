package com.learning.batlleship.players;

import com.learning.batlleship.ships.concreteships.Ship;
import com.learning.batlleship.util.Point;

import java.util.ArrayList;
import java.util.List;

public class User extends Player {

    @Override
    protected List<Ship> createShips() {
        return super.createShips();
    }

    @Override
    protected Ship[] getShips() {
        return super.getShips();
    }

    @Override
    protected void getName() {
        super.getName();
    }

    @Override
    protected boolean isFleetOnWater() {
        return super.isFleetOnWater();
    }

    @Override
    protected boolean checkOnRepeat(char[][] fieldForShots, Point coordinate) {
        return super.checkOnRepeat(fieldForShots, coordinate);
    }
}
