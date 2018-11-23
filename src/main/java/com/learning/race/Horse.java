package com.learning.race;

import java.util.concurrent.Callable;

public class Horse implements Callable<String> {
    String name;
    private int speed;
    private int acceleration;

    public Horse(String name, int speed) {
        this.name = name;
        this.speed = speed;
        setAcceleration();
    }

    public void setAcceleration() {
        acceleration = (int)(Math.random()*(10 - speed));
    }

    @Override
    public String call() throws Exception {
        System.out.println(name + " is accelerating");
        long time = acceleration * speed * 10;

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name + "has finished";
    }
}
