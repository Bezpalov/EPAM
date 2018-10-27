package tests.java.com.learning.bank.atm;

import main.com.learning.bank.Account;
import main.com.learning.bank.atm.AdvancedATM;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdvancedATMTest {
    AdvancedATM advancedATMT;
    Account account;

    @Before
    public void init() {
        advancedATMT = new AdvancedATM();
        account = Account.getAccount();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCashExceptionAccount() {
        advancedATMT.getCash(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCashExceptionMoney() {
        advancedATMT.getCash(account, 0);
    }

    @Test
    public void testGetCash() {
        account.putMoney(10);
        assertEquals("you have got 10.0RUB", advancedATMT.getCash(account, 10));
        assertEquals("There is no enough money on account", advancedATMT.getCash(account, 1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPurMoneyExceptionAccount() {
        advancedATMT.putMoney(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutMoneyExceptionMoney() {
        advancedATMT.putMoney(account, 0);
    }

    @Test
    public void testPutMoney() {
        assertEquals("10.0 RUB has been successfully deposited on account", advancedATMT.putMoney(account, 10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExchangeToUSDExceptionAccount() {
        advancedATMT.exchangeToUSD(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExchangeToUSDExceptionMoney() {
        advancedATMT.exchangeToUSD(account, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExchangeToEURExceptionAccount() {
        advancedATMT.exchangeToEUR(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExchangeToEURExceptionMoney() {
        advancedATMT.exchangeToEUR(account, 0);
    }

    @Test
    public void testExchangeToUSD() {
        account.putMoney(160);
        Assert.assertEquals("you are successfully received 2.0 usd", advancedATMT.exchangeToUSD(account, 2));
        Assert.assertEquals("There is no enough money on account", advancedATMT.exchangeToUSD(account, 2));
    }

    @Test
    public void testExchangeToEUR() {
        account.putMoney(160);
        Assert.assertEquals("you are successfully received 2.0 eur", advancedATMT.exchangeToEUR(account, 2));
        Assert.assertEquals("There is no enough money on account", advancedATMT.exchangeToEUR(account, 2));
    }


}
