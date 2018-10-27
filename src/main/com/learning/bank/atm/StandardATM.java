package main.com.learning.bank.atm;

import main.com.learning.bank.abilities.balance.ExistBalance;
import main.com.learning.bank.abilities.charge.Charge;
import main.com.learning.bank.abilities.exchange.NoExchange;

public class StandartATM extends ATM {

    public StandartATM() {
        balance = new ExistBalance();
        exchange = new NoExchange();
        charge = new Charge();
    }

    @Override
    public String toString() {
        return " from StandartATM";
    }
}
