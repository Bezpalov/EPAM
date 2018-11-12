package com.learning.bank.abilities.balance;

import com.learning.bank.Account;

/**
 * Interface that gives an opportunity to show account balance
 */
public interface Balance {

    /**
     * @param acc Account that balance has to be shown
     */
    void showBalance(Account acc);
}
