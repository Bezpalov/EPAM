package main.com.learning.recursion;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().executeAll());
    }

    /**
     *
     * @return Pull out information about all executed methods
     */
    public StringBuilder executeAll() {
        Executable factorial = new Factorial();
        Executable pow = new Pow();
        Executable quantityOfDigitsOfNaturalNumber = new QuantityOfDigitsOfNaturalNumber();
        Executable sumOfNaturalNumber = new SumOfNaturalNumber();
        StringBuilder result = new StringBuilder();

        List<Executable> execution = Arrays.asList(factorial, pow, quantityOfDigitsOfNaturalNumber, sumOfNaturalNumber);
        for (Executable ex : execution) {
            result.append(ex.execute());
        }
        return result;
    }
}
