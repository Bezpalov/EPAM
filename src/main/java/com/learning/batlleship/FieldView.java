package main.java.com.learning.batlleship;

import java.io.IOException;

public class FieldView {
    public void showFields (char[][] chars) {

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < chars[0].length ; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                line.append(chars[i][j]);
            }
            line.append("\n");
        }
        System.out.println(line);
    }

    public void clearFields() throws IOException, InterruptedException {

    }
}
