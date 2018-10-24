package main.com.learning.bank.atm;

import main.com.learning.bank.Account;
import main.com.learning.bank.balance.Balance;
import main.com.learning.bank.charge.Chargeable;
import main.com.learning.bank.exchange.Exchangeable;

public abstract class ATM {

    protected Balance balance;
    protected Exchangeable exchange;
    protected Chargeable charge;

    protected String getCash(Account acc, double money) {
        String result = "";
        try {
            result = acc.getMoney(money);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
