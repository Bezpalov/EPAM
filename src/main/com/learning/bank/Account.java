package main.com.learning.bank;

import java.math.BigDecimal;

/**
 * Class that represent an account in a bank.
 */
public class Account {
    private volatile BigDecimal count = BigDecimal.ZERO;
    private static final Account account = new Account();

    private Account() {
    }

    public synchronized String getMoney(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount of money must be positive");
        }

        BigDecimal temp = BigDecimal.valueOf(amount);
        if (count.compareTo(temp) < 0) {
            return "There is no enough money on account";
        }
        count = count.subtract(temp);
        return "you have got " + amount + "RUB";
    }

    public synchronized String putMoney(long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount of money must be more than zero");
        }

        BigDecimal temp = BigDecimal.valueOf(amount);
        count = count.add(temp);
        return amount + " RUB has been successfully deposit on account";
    }
}
