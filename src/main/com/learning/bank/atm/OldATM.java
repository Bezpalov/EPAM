package main.com.learning.bank.atm;

import main.com.learning.bank.abilities.balance.AbsenceBalance;
import main.com.learning.bank.abilities.charge.NoCharge;
import main.com.learning.bank.abilities.exchange.NoExchange;

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

    public static void main(String[] args) {

    }
}
