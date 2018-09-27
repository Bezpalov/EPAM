package com.learning.strings.zlatopolskiy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterPoint {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Task task = new Task();
        String word;
        String sentence;
        int index;

        while(true) {
            try {
                System.out.println("Enter the word (-1 to exit)");
                word = reader.readLine();
                if(word.equals("-1")) {
                    break;
                }

                System.out.println("Enter the index");
                index = Integer.parseInt(reader.readLine());

                System.out.println("Enter the sentence");
                sentence = reader.readLine();

                System.out.println("word is " + word.toUpperCase());
                System.out.println("third symbol is " + task.getThirdSymbol(word).toUpperCase());
                System.out.println("last symbol is " + task.getLastSymbol(word).toUpperCase());
                System.out.println(index + " symbol in the word " + word.toUpperCase() + " is " + task.getSpecificSymbol(word, index).toUpperCase());
                System.out.println("change 2 and 5 symbol: " + task.changeLettersSpot(word));
                System.out.println("Quantity of equals letter in " + sentence.toUpperCase() + " is " + task.getQuantityOfEqualsLetters(sentence));
            } catch (IOException e) {
                e.getStackTrace();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

