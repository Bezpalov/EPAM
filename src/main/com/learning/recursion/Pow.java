package main.com.learning.recursion;

public class Pow {

    public int getPowOfNumber (int number, int pow) {
        if (pow == 1) {
            return number;
        }
        return number * getPowOfNumber(number, pow - 1);
    }
}
