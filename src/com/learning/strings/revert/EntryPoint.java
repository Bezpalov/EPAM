package com.learning.strings.revert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntryPoint {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sentence;

        while (true) {
            try {
                System.out.println("Enter the sentence (-1 to exit)");
                sentence = reader.readLine();
                if (sentence.equals("-1")) {
                    break;
                }
                System.out.println(Revert.revertSentence(sentence));
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
