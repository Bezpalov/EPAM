package com.learning.arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ArrayHelperTest {
    ArrayHelper arrayHelper;
    char[][] array;

    @Before
    public void init() {
        arrayHelper = new ArrayHelper();
        array = ArrayHelper.getTwoDimensionalArray();
    }

    @Test
    public void testGetTwoDimensionalArray() {
        assertNotNull(ArrayHelper.getTwoDimensionalArray());
    }

    @Test
    public void testExecute() {
        assertNotNull(arrayHelper.execute(array));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExecuteNullonEnter() {
        arrayHelper.execute(null);
    }
}
