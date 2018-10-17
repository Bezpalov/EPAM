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

    @Override
    public StringBuilder execute() {
        return null;
    }
}
