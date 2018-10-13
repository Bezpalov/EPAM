package main.com.learning.strings.zlatopolskiy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntryPoint {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Task task = new Task();
        String word;
        String sentence;
        int index;

        while (true) {
            try {
                System.out.println("Enter the word (-1 to exit)");
                word = reader.readLine();
                if (word.equals("-1")) {
                    break;
                }

                System.out.println("Enter the index");
                index = Integer.parseInt(reader.readLine());

                System.out.println("Enter the sentence");
                sentence = reader.readLine();

                System.out.println("word is " + word.toUpperCase());

                try {
                    System.out.println("third symbol is " + task.getThirdSymbol(word).toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
                try {
                    System.out.println("last symbol is " + task.getLastSymbol(word).toUpperCase());
                } catch (NullPointerException | IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
                try {
                    System.out.println(index + " symbol in the word " + word.toUpperCase() + " is " + task.getSpecificSymbol(word, index).toUpperCase());
                } catch (NullPointerException | IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
                try {
                    System.out.println("change 2 and 5 symbol: " + task.changeLettersSpot(word));
                }catch (NullPointerException | IllegalArgumentException e){
                    System.err.println(e.getMessage());
                }
                try {
                    System.out.println("Quantity of equals letter in " + sentence.toUpperCase() + " is " + task.getQuantityOfEqualsLetters(sentence));
                }catch (NullPointerException e){
                    System.err.println(e.getMessage());
                }
            } catch (IOException e) {
                e.getStackTrace();
            }
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

