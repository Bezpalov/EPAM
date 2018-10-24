package main.com.learning.bank;

public class Charge implements Chargeable {
    @Override
    public String deposit(Account acc, long money) {
        if (acc == null) {
            throw new IllegalArgumentException("Account must exist");
        } else if (money <= 0) {
            throw new IllegalArgumentException("Money must be more than zero");
        }

        return acc.putMoney(money);
    }
}
