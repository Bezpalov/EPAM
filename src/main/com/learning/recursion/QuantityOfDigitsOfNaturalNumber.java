package main.com.learning.recursion;

import java.math.BigDecimal;

/**
 * Class for calculating amount of digits of some number
 *
 * @author Eugeniy Zozulya
 * @version 1.0
 */
public class QuantityOfDigitsOfNaturalNumber implements Executable {

    /**
     * @param number - any positive integer number or 0 and constrained by MAX_VALUE of type Long
     * @return integer representing amount of digits of a number
     * @throws IllegalArgumentException - if parameter is negative
     */
    public Long getQuantityOfDigitsOfNaturalNumber(Long number) {
        if (number < 0) {
            throw new IllegalArgumentException("parameter must be positive or 0");
        }

        if (number < 10) {
            return 1L;
        }
        return 1 + getQuantityOfDigitsOfNaturalNumber(number / 10);
    }

    @Override
    public StringBuilder execute() {
        return null;
    }
}
