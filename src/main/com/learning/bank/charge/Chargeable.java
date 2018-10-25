package main.com.learning.bank.charge;

import main.com.learning.bank.Account;

public interface Chargeable {

    String deposit(Account acc, long money);
}
