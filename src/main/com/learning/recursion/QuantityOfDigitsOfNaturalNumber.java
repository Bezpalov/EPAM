package main.com.learning.recursion;

public class QuantityOfDigitsOfNaturalNumber {

    public int getQuantityOfDigitsOfNaturalNumber(int number) {
        if(number < 10) {
            return 1;
        }
        return 1 + getQuantityOfDigitsOfNaturalNumber(number / 10);
    }
}
