package main.com.learning.bank;

public interface Exchangeable {
    String getUSD(Account acc, double usd);

    String getEUR(Account acc, double eur);
}
