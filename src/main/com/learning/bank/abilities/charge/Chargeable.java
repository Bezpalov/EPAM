package main.com.learning.bank.abilities.charge;

import main.com.learning.bank.Account;

public interface Chargeable {
    String deposit(Account acc, double money);
}
