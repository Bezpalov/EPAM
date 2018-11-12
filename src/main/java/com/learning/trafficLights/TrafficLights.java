package com.learning.trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLights {
    /*
    Сделать светофор с выводом цвета в консоль.
    Вы вводите минуту (от нуля до n) и получаете какой свет горит на светофоре.
    Первые две минуты красный, потом три минуты желтый и пять минут зеленый.
     */

    public static void main(String[] args) throws IOException {
        int intMinute;
        String answer;
        String stringMinute;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Enter a minute (\"exit\" to stop)");
            stringMinute = reader.readLine();

            if (stringMinute.equals("exit")) {
                System.exit(0);
            }

            try {
                intMinute = Integer.parseInt(stringMinute);
            } catch (NumberFormatException e) {
                System.err.println("Wrong format");
                continue;
            }
            intMinute = intMinute % 10;

            if (intMinute <= 2 && intMinute >= 0) {
                answer = "red";
            } else if (intMinute > 5) {
                answer = "green";
            } else if (intMinute > 2 && intMinute <= 5) {
                answer = "yellow";
            } else {
                answer = "no";
            }
            System.out.println(answer + " light is on");
        }
    }
}