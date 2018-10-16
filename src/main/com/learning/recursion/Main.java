package main.com.learning.recursion;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Factorial().getFactorial(5));
        System.out.println(new Pow().getPowOfNumber(2,3));
        System.out.println(new QuantityOfDigitsOfNaturalNumber().getQuantityOfDigitsOfNaturalNumber(12356));
        System.out.println(new SumOfNaturalNumber().getSumOfNaturalNumber(12345));
    }
}
