package main.com.learning.bank.atm;

import main.com.learning.bank.balance.AbsenceBalance;
import main.com.learning.bank.charge.NoCharge;
import main.com.learning.bank.exchange.NoExchange;

public class OldATM extends ATM {

    public OldATM() {
        balance = new AbsenceBalance();
        exchange = new NoExchange();
        charge = new NoCharge();
    }
}
