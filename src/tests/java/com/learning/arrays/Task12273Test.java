package com.learning.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Task12273Test {

    Task12273 task12273;
    char[][] concreteArray;

    @Before
    public void init() {
        task12273 = new Task12273();
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
    public void testGetEveWordsNullIn() {
        task12273.getEvenWords(null);
    }

    @Test
    public void testGetEveWordsNull() {
        String out = "Even words is: b e h";
        Assert.assertEquals(out, task12273.getEvenWords(concreteArray).toString().trim());
    }
}
