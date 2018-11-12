package com.learning.bank.abilities.balance;

import com.learning.bank.Account;

/**
 * Class represented ATMs with no possibility to show balance
 */
public class AbsenceBalance implements Balance {

    @Override
    public void showBalance(Account acc) {
        System.out.println("This kind of ATM doesn't maintain balance mapping");
    }
}
