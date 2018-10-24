package main.com.learning.bank.atm;

import main.com.learning.bank.balance.ExistBalance;
import main.com.learning.bank.charge.Charge;
import main.com.learning.bank.exchange.Exchange;

public class AdvancedATM extends ATM {
    public AdvancedATM() {
        balance = new ExistBalance();
        exchange = new Exchange();
        charge = new Charge();
    }
}
