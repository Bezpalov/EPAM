package main.com.learning.recursion;

public interface Executable {
    StringBuilder execute();

    static Long getRandomPositiveNumber() {
        return (long)(Math.round(Math.random()*25));
    }

    static Long getRandomNumber() {
        return -25 + Math.round(Math.random()*50);
    }

    static Long getRandomNegativeNumber(){
        return (long)(-Math.round(Math.random()*25));
    }
}
