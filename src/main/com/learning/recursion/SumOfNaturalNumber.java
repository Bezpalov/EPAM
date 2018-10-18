package main.com.learning.recursion;

/**
 * Class for calculating sum of digits of natural number
 *
 * @author Eugeniy Zozulya
 * @version 1.0
 */
public class SumOfNaturalNumber implements Executable {

    /**
     * @param number - any positive integer number or 0 and constrained by MAX_VALUE of type Long
     * @return integer representing sum of digits of a number
     * @throws IllegalArgumentException if parameter is negative
     */
    public Long getSumOfNaturalNumber(Long number) {
        if (number < 10) {
            return number;
        }
        return (number % 10) + getSumOfNaturalNumber(number / 10);
    }

    /**
     * Realization of interface method execute. Pull out all information through StringBuilder object
     *
     * @return answer about sum of digits of some natural number
     */
    @Override
    public StringBuilder execute() {
        try {
            long number = Executable.getRandomPositiveNumber();
            StringBuilder result = new StringBuilder("Sum of digits of natural number ")
                    .append(Long.toString(number))
                    .append(" is ")
                    .append(getSumOfNaturalNumber(number))
                    .append("\n");
            return result;
        } catch (StackOverflowError e) {
            System.err.println("Error in getFactorial: There is too much depth for this algorithm ");
        } catch (IllegalArgumentException e) {
            System.err.println("Error in getSumOfNaturalNumber: " + e.getMessage());
        }
        return new StringBuilder("");
    }
}
