package main.com.learning.bank.atm;

import main.com.learning.bank.abilities.balance.ExistBalance;
import main.com.learning.bank.abilities.charge.Charge;
import main.com.learning.bank.abilities.exchange.Exchange;

public class AdvancedATM extends ATM {

    public AdvancedATM() {
        balance = new ExistBalance();
        exchange = new Exchange();
        charge = new Charge();
    }

    @Override
    public String toString() {
        return " from AdvancedATM";
    }
}
