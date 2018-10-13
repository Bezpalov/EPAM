package tests.java.com.learning.arrays;

import main.com.learning.arrays.ArrayHelper;
import main.com.learning.arrays.Task12270;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Task12270Test {

    Task12270 task12270;
    char[][] randomArray;
    char[][] concreteArray;

    @Before
    public void init() {
        task12270 = new Task12270();
        randomArray = ArrayHelper.getTwoDimensionalArray();
        concreteArray = new char[2][2];
        concreteArray[0][0] = 'a';
        concreteArray[0][1] = 'b';
        concreteArray[1][0] = 'c';
        concreteArray[1][1] = 'd';
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCornersNullIn() {
        task12270.getCorners(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCornersToSmallArray() {
        task12270.getCorners(new char[1][1]);
    }

    @Test
    public void testGetCornersOut() {
        assertNotNull(task12270.getCorners(randomArray));
        assertEquals("Symbols from corners: abcd", task12270.getCorners(concreteArray).toString());
    }
}
