package main.com.learning.bank.atm;

import main.com.learning.bank.balance.ExistBalance;
import main.com.learning.bank.charge.Charge;
import main.com.learning.bank.exchange.NoExchange;

public class StandartATM extends ATM {
    public StandartATM() {
        balance = new ExistBalance();
        exchange = new NoExchange();
        charge = new Charge();
    }
}
