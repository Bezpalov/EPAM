package com.learning.bank.abilities.charge;

import com.learning.bank.Account;

/**
 * Class represented ATMs with possibility to charge balance
 */
public class Charge implements Chargeable {

    @Override
    public String deposit(Account acc, double money) {
        if (acc == null) {
            throw new IllegalArgumentException("Account must exist");
        } else if (money <= 0) {
            throw new IllegalArgumentException("Money must be more than zero");
        }
        return acc.putMoney(money);
    }
}
