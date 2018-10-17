package main.com.learning.recursion;

import java.math.BigInteger;
import java.sql.SQLOutput;

/**
 * Class for calculating factorial of a natural number
 *
 * @author Eugeniy Zozulya
 * @version 1.0
 */
public class Factorial implements Executable {

    /**
     * @param number - integer that must be more or equal zero and constrained by MAX_VALUE of type Long
     * @return integer number in BigInteger type representing factorial of method parameter "number"
     * @throws IllegalArgumentException - if parameter less than 0
     */
    public BigInteger getFactorial(Long number) {
        if (number < 0) {
            throw new IllegalArgumentException("parameter number should be more or equal zero");
        } else if (number == 0) {
            return BigInteger.ZERO;
        }

        if (number == 1) {
            return BigInteger.ONE;
        }
        return new BigInteger(number.toString()).multiply(getFactorial((number - 1)));
    }

    @Override
    public StringBuilder execute() {
        try {
            long number = Executable.getRandomPositiveNumber();
            StringBuilder result = new StringBuilder("factorial of number ").append(number).
                    append(" is ");
            result.append(getFactorial(number));
            return null;
        }catch (StackOverflowError e) {
            System.out.println("There is too ");
        }
    }
}
