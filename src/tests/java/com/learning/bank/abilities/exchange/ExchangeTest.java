package tests.java.com.learning.bank.abilities.exchange;

import main.com.learning.bank.Account;
import main.com.learning.bank.abilities.exchange.Exchange;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExchangeTest {
    Account account;
    Exchange exchange;

    @Before
    public void init() {
        account = Account.getAccount();
        exchange = new Exchange();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetUSDExceptionAccount() {
        exchange.getUSD(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetUSDExceptionMoney() {
        exchange.getUSD(account, 0);
    }

    @Test
    public void testGetUSD() {
        account.putMoney(160);
        Assert.assertEquals("you are successfully received 2.0 usd", exchange.getUSD(account, 2));
        Assert.assertEquals("There is no enough money on account", exchange.getUSD(account, 2));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetEURExceptionAccount() {
        exchange.getEUR(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetEURExceptionMoney() {
        exchange.getEUR(account, 0);
    }

    @Test
    public void testGetEUR() {
        account.putMoney(160);
        Assert.assertEquals("you are successfully received 2.0 eur", exchange.getEUR(account, 2));
        Assert.assertEquals("There is no enough money on account", exchange.getEUR(account, 2));
    }
}
