package main.com.learning.recursion;

public class Factorial {

    /**
     *
     * @param number
     * @return
     */
    public int getFactorial(int number) {
        if (number == 1) {
            return 1;
        }
        return number * getFactorial(number - 1);
    }
}
