package main.com.learning.recursion;

public class SumOfNaturalNumber {

    public int getSumOfNaturalNumber(int number) {
        if(number < 10) {
            return number;
        }
        return (number % 10) + getSumOfNaturalNumber(number / 10);
    }
}
