package main.com.learning.bank.abilities.charge;

import main.com.learning.bank.Account;

/**
 * Class represented ATMs with no possibility to charge balance
 */
public class NoCharge implements Chargeable {

    @Override
    public String deposit(Account acc, double money) {
        return "This kind of ATM has no ability to deposit";
    }
}
