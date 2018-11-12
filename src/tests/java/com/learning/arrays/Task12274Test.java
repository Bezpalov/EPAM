package com.learning.arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task12274Test {
    Task12274 task12274;
    char[][] concreteArray;

    @Before
    public void init() {
        task12274 = new Task12274();
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
        task12274.getOddWords(null);
    }

    @Test
    public void testGetEveWordsNull() {
        String out = "odd word is: ac df gi";
        assertEquals(out, task12274.getOddWords(concreteArray).toString().trim());
    }
}
