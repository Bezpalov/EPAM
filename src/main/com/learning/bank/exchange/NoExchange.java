package main.com.learning.bank.exchange;

import main.com.learning.bank.Account;

public class NoExchange implements Exchangeable {
    @Override
    public String getUSD(Account acc, double usd) {
        return "This kind of ATM doesn't exchange money";
    }

    @Override
    public String getEUR(Account acc, double eur) {
        return "This kind of ATM doesn't exchange money";
    }
}
