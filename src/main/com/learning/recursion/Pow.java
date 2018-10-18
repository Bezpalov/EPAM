package main.com.learning.recursion;

import java.math.BigInteger;

/**
 * Class for calculating exponentiation of a number
 *
 * @author Eugeniy Zozulya
 * @version 1.0
 */
public class Pow implements Executable {

    /**
     * @param number - digit for exponentiation, constrained by MAX_VALUE and MIN_VALUE of type Long
     * @param pow    - exponent, must be positive or 0 and constrained by MAX_VALUE of type Long
     * @return integer number in BigInteger type representing parameter in a specific power
     * @throws IllegalArgumentException - if parameter pow is negative
     */
    public BigInteger getPowOfNumber(Long number, Long pow) {
        if (pow < 0) {
            throw new IllegalArgumentException("power must be positive or 0");
        } else if (number == 0) {
            return BigInteger.ZERO;
        } else if (pow == 0) {
            return BigInteger.ONE;
        }

        BigInteger temp = new BigInteger(number.toString());
        if (pow == 1) {
            return temp;
        }
        return temp.multiply(getPowOfNumber(number, pow - 1));
    }

    /**
     * Realization of interface method execute. Pull out all information through StringBuilder object
     *
     * @return answer about raising number to some power
     */
    @Override
    public StringBuilder execute() {
        try {
            long number = Executable.getRandomNumber();
            long pow = Executable.getRandomPositiveNumber();
            StringBuilder result = new StringBuilder(Long.toString(number));
            result.append(" raised to a power ")
                    .append(Long.toString(pow))
                    .append(" is ")
                    .append(getPowOfNumber(number, pow))
                    .append("\n");
            return result;
        } catch (StackOverflowError e) {
            System.err.println("Error in getFactorial: There is too much depth for this algorithm ");
        } catch (IllegalArgumentException e) {
            System.err.println("Error in getPow: " + e.getMessage());
        }
        return new StringBuilder("");
    }
}
