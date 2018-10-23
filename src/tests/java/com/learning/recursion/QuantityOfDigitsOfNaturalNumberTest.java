package tests.java.com.learning.recursion;

import main.com.learning.recursion.QuantityOfDigitsOfNaturalNumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityOfDigitsOfNaturalNumberTest {
    QuantityOfDigitsOfNaturalNumber quantityOfDigitsOfNaturalNumber;

    @Before
    public void init() {
        quantityOfDigitsOfNaturalNumber = new QuantityOfDigitsOfNaturalNumber();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetQuantityOfDigitsOfNaturalNumberException() {
        quantityOfDigitsOfNaturalNumber.getQuantityOfDigitsOfNaturalNumber(-1L);
    }

    @Test
    public void testGetQuantityOfDigitsOfNaturalNumber() {
        assertEquals(new Long(5), quantityOfDigitsOfNaturalNumber.getQuantityOfDigitsOfNaturalNumber(12345L));
        assertEquals(new Long(6), quantityOfDigitsOfNaturalNumber.getQuantityOfDigitsOfNaturalNumber(123456L));
        assertEquals(new Long(2), quantityOfDigitsOfNaturalNumber.getQuantityOfDigitsOfNaturalNumber(12L));
    }

    @Test
    public void testExecute() {
        assertTrue(quantityOfDigitsOfNaturalNumber.execute().toString().startsWith("Quantity of digits of natural number"));
    }
}
