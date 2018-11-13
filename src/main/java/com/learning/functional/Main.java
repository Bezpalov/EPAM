package main.java.com.learning.functional;

public class Main {
    public static void main(String[] args) {
        MyFunctionalInterface myFunctionalInterface = (a, b) -> a.concat(b);
        System.out.println(myFunctionalInterface.apply("Hello", " world"));
    }
}
