package tests.java.com.learning.arrays;

import main.com.learning.arrays.ArrayHelper;
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
