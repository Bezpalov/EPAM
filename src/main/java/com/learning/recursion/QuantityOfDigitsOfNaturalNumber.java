package com.learning.recursion;

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

    /**
     * Realization of interface method execute. Pull out all information through StringBuilder object
     *
     * @return answer about quantity of digits of some natural number
     */
    @Override
    public StringBuilder execute() {
        try {
            long number = Executable.getRandomPositiveNumber();
            StringBuilder result = new StringBuilder("Quantity of digits of natural number ")
                    .append(Long.toString(number))
                    .append(" is ")
                    .append(getQuantityOfDigitsOfNaturalNumber(number))
                    .append("\n");
            return result;
        } catch (StackOverflowError e) {
            System.err.println("Error in getFactorial: There is too much depth for this algorithm ");
        } catch (IllegalArgumentException e) {
            System.err.println("Error in getQuantityOfNaturalNumber: " + e.getMessage());
        }
        return new StringBuilder("");
    }
}
