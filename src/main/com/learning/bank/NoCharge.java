package main.com.learning.bank;

public class NoCharge implements Chargeable {
    @Override
    public String deposit(Account acc, long money) {
        return "This kind of ATM has no ability to deposit";
    }
}