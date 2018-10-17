package main.com.learning.recursion;

import java.math.BigInteger;

/**
 * Class for calculating exponentiation of a number
 *
 * @author Eugeniy Zozulya
 * @version 1.0
 */
public class Pow implements Executable{

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

    @Override
    public StringBuilder execute() {
        return null;
    }
}
