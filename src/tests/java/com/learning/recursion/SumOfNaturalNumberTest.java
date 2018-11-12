package com.learning.recursion;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SumOfNaturalNumberTest {
    SumOfNaturalNumber sumOfNaturalNumber;

    @Before
    public void init() {
        sumOfNaturalNumber = new SumOfNaturalNumber();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetQuantityOfDigitsOfNaturalNumberException() {
        sumOfNaturalNumber.getSumOfNaturalNumber(-1L);
    }

    @Test
    public void testGetQuantityOfDigitsOfNaturalNumber() {
        assertEquals(new Long(5), sumOfNaturalNumber.getSumOfNaturalNumber(11111L));
        assertEquals(new Long(6), sumOfNaturalNumber.getSumOfNaturalNumber(51L));
        assertEquals(new Long(2), sumOfNaturalNumber.getSumOfNaturalNumber(20L));
    }

    @Test
    public void testExecute() {
        assertTrue(sumOfNaturalNumber.execute().toString().startsWith("Sum of digits of natural number"));
    }
}
