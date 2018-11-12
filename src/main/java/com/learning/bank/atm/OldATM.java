package com.learning.bank.atm;

import com.learning.bank.abilities.balance.AbsenceBalance;
import com.learning.bank.abilities.charge.NoCharge;
import com.learning.bank.abilities.exchange.NoExchange;

/**
 * Realization of ATM with ability to get money
 */
public class OldATM extends ATM {

    public OldATM() {
        balance = new AbsenceBalance();
        exchange = new NoExchange();
        charge = new NoCharge();
    }

    @Override
    public String toString() {
        return " from OldATM";
    }
}
