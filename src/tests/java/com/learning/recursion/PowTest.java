package tests.java.com.learning.recursion;

import main.com.learning.recursion.Executable;
import main.com.learning.recursion.Pow;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class PowTest {
    Pow pow;

    @Before
    public void init() {
        pow = new Pow();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPowerOfNumberException() {
        pow.getPowOfNumber(Executable.getRandomNumber(), -1L);
    }

    @Test
    public void testGetPowOfNumber() {
        assertEquals(BigInteger.ZERO, pow.getPowOfNumber(0L, Executable.getRandomPositiveNumber()));
        assertEquals(BigInteger.ONE, pow.getPowOfNumber(Executable.getRandomNumber(), 0L));
        assertEquals(new BigInteger("1024"), pow.getPowOfNumber(2L, 10L));
    }

    @Test
    public void testExecute() {
        assertTrue(pow.execute().toString().contains("raised to a power"));
    }
}
