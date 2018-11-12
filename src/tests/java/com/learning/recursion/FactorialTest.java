package com.learning.recursion;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class FactorialTest {
    Factorial factorial = new Factorial();

    @Before
    public void init() {
        factorial = new Factorial();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialException() {
        factorial.getFactorial(-1L);
    }

    @Test
    public void testGetFactorial() {
        assertEquals(BigInteger.ONE, factorial.getFactorial(1L));
        assertEquals(new BigInteger("120"), factorial.getFactorial(5L));
    }

    @Test
    public void testExecute() {
        assertTrue(factorial.execute().toString().startsWith("factorial of number "));
    }
}
