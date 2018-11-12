package com.learning.bank.atm;

import com.learning.bank.Account;
import com.learning.bank.abilities.balance.Balance;
import com.learning.bank.abilities.charge.Chargeable;
import com.learning.bank.abilities.exchange.Exchangeable;

import java.math.BigDecimal;

/**
 * abstract class representing an ATM with some functionality
 */
public abstract class ATM implements Runnable {

    private static final Object mutex = new Object();

    protected Balance balance;
    protected Exchangeable exchange;
    protected Chargeable charge;

    /**
     * @param acc   account to get cash from
     * @param money amount of money
     * @return String representation of result of operation
     */
    public String getCash(Account acc, double money) {
        if (acc == null) {
            throw new IllegalArgumentException("Account must exist");
        } else if (money <= 0) {
            throw new IllegalArgumentException("Money must be more than zero");
        }

        String result = "unpredictable mistake";
        try {
            result = acc.getMoney(money);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    /**
     * @param acc Account that balance has to be shown
     */
    public void getBalance(Account acc) {
        balance.showBalance(acc);
    }

    /**
     * @param acc   account to put cash to
     * @param money amount of money
     * @return String representation of result of operation
     */
    public String putMoney(Account acc, double money) {
        if (acc == null) {
            throw new IllegalArgumentException("Account must exist");
        } else if (money <= 0) {
            throw new IllegalArgumentException("Money must be more than zero");
        }
        return charge.deposit(acc, money);
    }

    /**
     * @param acc   account of exchange
     * @param money amount of money
     * @return String representation of result of operation
     */
    public String exchangeToUSD(Account acc, double money) {
        if (acc == null) {
            throw new IllegalArgumentException("Account must exist");
        } else if (money <= 0) {
            throw new IllegalArgumentException("Money must be more than zero");
        }
        return exchange.getUSD(acc, money);
    }

    /**
     * @param acc   account of exchange
     * @param money amount of money
     * @return String representation of result of operation
     */
    public String exchangeToEUR(Account acc, double money) {
        if (acc == null) {
            throw new IllegalArgumentException("Account must exist");
        } else if (money <= 0) {
            throw new IllegalArgumentException("Money must be more than zero");
        }
        return exchange.getEUR(acc, money);
    }

    /**
     * common logic of various ATMs.
     * Some methods execution depends from context
     */
    @Override
    public void run() {
        Account acc = Account.getAccount();

        System.out.println(Thread.currentThread());
        System.out.println("Trying to put money");
        System.out.println(putMoney(acc, 10000));
        getBalance(acc);
        System.out.println();

        do {
            synchronized (mutex) {
                System.out.println(Thread.currentThread());
                getBalance(acc);
                System.out.println("Trying to get money" + toString());
                System.out.println(getCash(acc, 20));
                System.out.print("After operation ");
                getBalance(acc);
                System.out.println("Trying to get currency");
                System.out.println(exchangeToEUR(acc, 2));
                System.out.print("After exchange ");
                getBalance(acc);
                System.out.println();

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (acc.showBalance().compareTo(BigDecimal.ZERO) > 0);
    }
}
