package main.com.learning.recursion;

import java.math.BigInteger;

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

    /**
     * Realization of interface method execute. Pull out all information through StringBuilder object
     *
     * @return answer about factorial of a number
     */
    @Override
    public StringBuilder execute() {
        try {
            StringBuilder result = new StringBuilder("factorial of number ");
            long number = Executable.getRandomPositiveNumber();
            result.append(number)
                    .append(" is ")
                    .append(getFactorial(number))
                    .append("\n");
            return result;
        } catch (StackOverflowError e) {
            System.err.println("Error in getFactorial: There is too much depth for this algorithm ");
        } catch (IllegalArgumentException e) {
            System.err.println("Error in getFactorial: " + e.getMessage());
        }
        return new StringBuilder("");
    }
}

