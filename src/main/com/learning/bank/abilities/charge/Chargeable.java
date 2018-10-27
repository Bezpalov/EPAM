package main.com.learning.bank.abilities.charge;

import main.com.learning.bank.Account;

/**
 * Interface that gives an opportunity to charge account balance
 */
public interface Chargeable {

    /**
     * @param acc   Account that need to be charged
     * @param money amount of money
     * @return successfully or not result of operation in String
     */
    String deposit(Account acc, double money);
}
