package com.learning.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Task12271Test {

    Task12271 task12271;
    char[][] randomArray;
    char[][] concreteArray;

    @Before
    public void init() {
        task12271 = new Task12271();
        randomArray = ArrayHelper.getTwoDimensionalArray();
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
    public void testGetWordNullArray() {
        task12271.getWord(null, 1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordNegativeLineNumber() {
        task12271.getWord(randomArray, -1, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordBeginTooBig() {
        task12271.getWord(concreteArray, 1, 4, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordBeginNegative() {
        task12271.getWord(concreteArray, 1, -1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordEndNegative() {
        task12271.getWord(concreteArray, 1, 1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordEndTooBig() {
        task12271.getWord(concreteArray, 1, 1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordBeginMoreThanEnd() {
        task12271.getWord(concreteArray, 1, 3, 2);
    }

    @Test
    public void testGetWord() {
        String expected = "a substring from 1 string is ef\n";
        Assert.assertEquals(expected, task12271.getWord(concreteArray, 1, 1, 2).toString());
    }
}
