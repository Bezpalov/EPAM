package com.learning.bank;

import java.math.BigDecimal;

/**
 * Class that representing an account in a bank.
 */
public class Account {
    private volatile BigDecimal count = BigDecimal.ZERO;
    private static final Account account = new Account();

    private Account() {
    }

    public static Account getAccount() {
        return account;
    }

    /**
     * @param amount amount of money
     * @return String representation of result of operation
     */
    public synchronized String getMoney(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount of money must be positive");
        }

        BigDecimal temp = BigDecimal.valueOf(amount);
        if (count.compareTo(temp) < 0) {
            return "There is no enough money on account";
        }
        count = count.subtract(temp);
        return "you have got " + amount + "RUB";
    }

    /**
     * @param amount amount of money
     * @return String representation of result of operation
     */
    public synchronized String putMoney(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount of money must be more than zero");
        }

        BigDecimal temp = BigDecimal.valueOf(amount);
        count = count.add(temp);
        return amount + " RUB has been successfully deposited on account";
    }

    /**
     * @return balance of an account in BigDecimal
     */
    public synchronized BigDecimal showBalance() {
        return count;
    }
}
