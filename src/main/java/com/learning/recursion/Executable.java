package com.learning.recursion;

public interface Executable {

    StringBuilder execute();

    /**
     * Utility method that return pseudo random number in range
     * from 0 to 25
     *
     * @return long primitive type from 0 to 25
     */
    static Long getRandomPositiveNumber() {
        return (long) (Math.round(Math.random() * 25));
    }

    /**
     * Utility method that return pseudo random number in range
     * from -25 to 25
     *
     * @return long primitive type from -25 to 25
     */
    static Long getRandomNumber() {
        return -25 + Math.round(Math.random() * 50);
    }

    /**
     * Utility method that return pseudo random number in range
     * from -25 to 0
     *
     * @return long primitive type from -25 to 0
     */
    static Long getRandomNegativeNumber() {
        return (long) (-Math.round(Math.random() * 25));
    }
}
