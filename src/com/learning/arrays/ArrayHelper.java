package com.learning.arrays;

public class ArrayHelper {
    public static char[][] getTwoDimensionArray(){
        char[][] array = new char[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                long element = Math.round(Math.random() * 25);
                array[i][j] = (char)(65 + element);
            }
        }
        return array;
    }

    public static void showArray(char[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public String execute(char[][] array) {

        showArray(array);
        System.out.println();

        StringBuilder result = new StringBuilder();
        try {
            result.append(new Task12270().getCorners(array));
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
        try {

        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }try {
            Task12272 task12272 = new Task12272();
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }try {
            Task12273 task12273 = new Task12273();
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }try {
            Task12274 task12274 = new Task12274();
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }

    }
}
