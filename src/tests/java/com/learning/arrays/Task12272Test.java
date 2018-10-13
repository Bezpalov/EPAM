package tests.java.com.learning.arrays;

import main.com.learning.arrays.Task12272;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Task12272Test {

    Task12272 task12272;
    char[][] concreteArray;

    @Before
    public void init() {
        task12272 = new Task12272();
        concreteArray = new char[3][3];
        concreteArray[0][0] = 'a';
        concreteArray[0][1] = 'b';
        concreteArray[0][2] = 'c';
        concreteArray[1][0] = 'd';
        concreteArray[1][1] = 'e';
        concreteArray[1][2] = 'f';
        concreteArray[2][0] = 'g';
        concreteArray[2][1] = 'h';
        concreteArray[2][2] = 'i';
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListToArray() {
        Task12272.listToArray(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLeftToRightNullIn() {
        task12272.getLeftToRigth(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLeftToRightWrongLengthHorizontal() {
        char[][] temp = new char[1][1];
        task12272.getLeftToRigth(temp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLeftToRightWrongVertical() {
        char[][] temp = new char[1][1];
        task12272.getLeftToRigth(temp);
    }

    @Test
    public void testGetLeftToRight() {
        String out = "left to right word is acegi\n";
        Assert.assertEquals(out, task12272.getLeftToRigth(concreteArray).toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpToDownNullIn() {
        task12272.getUpToDown(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpToDownWrongLengthHorizontal() {
        char[][] temp = new char[1][1];
        task12272.getUpToDown(temp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetUpRoDownWrongVertical() {
        char[][] temp = new char[1][1];
        task12272.getUpToDown(temp);
    }

    @Test
    public void testGetUpToDown() {
        String out = "up to down word is ageci\n";
        Assert.assertEquals(out, task12272.getUpToDown(concreteArray).toString());
    }
}
