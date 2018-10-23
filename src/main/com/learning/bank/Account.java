package main.com.learning.bank;

import java.math.BigDecimal;

/**
 * Class that represent an account in a bank.
 *
 */
public class Account {
    private volatile BigDecimal count = BigDecimal.ZERO;
    private static final Account account = new Account();

    private Account() {
    }

    public synchronized boolean getMoney(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount of money must be positive");
        }

        BigDecimal temp = BigDecimal.valueOf(amount);
        if (count.compareTo(temp) < 0) {
            return false;
        }
        count = count.subtract(temp);
        return true;
    }

    public synchronized void putMoney (long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount of money must be positive");
        }

        BigDecimal temp = BigDecimal.valueOf(amount);
        count = count.add(temp);
    }
}
