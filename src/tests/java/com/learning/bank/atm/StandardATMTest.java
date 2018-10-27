package tests.java.com.learning.bank.atm;

import main.com.learning.bank.Account;
import main.com.learning.bank.atm.StandardATM;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class StandardATMTest {
    StandardATM standardATM;
    Account account;

    @Before
    public void init() {
        standardATM = new StandardATM();
        account = Account.getAccount();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCashExceptionAccount() {
        standardATM.getCash(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCashExceptionMoney() {
        standardATM.getCash(account, 0);
    }

    @Test
    public void testGetCash() {
        account.putMoney(10);
        assertEquals("you have got 10.0RUB", standardATM.getCash(account, 10));
        assertEquals("There is no enough money on account", standardATM.getCash(account, 1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutMoneyExceptionAccount() {
        standardATM.putMoney(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutMoneyExceptionMoney() {
        standardATM.putMoney(account, 0);
    }

    @Test
    public void testPutMoney() {
        assertEquals("10.0 RUB has been successfully deposited on account", standardATM.putMoney(account, 10));
    }

    @Test
    public void testExchangeToUSD() {
        Assert.assertEquals("This kind of ATM doesn't exchange money", standardATM.exchangeToUSD(account, 2));
    }

    @Test
    public void testExchangeToEUR() {
        Assert.assertEquals("This kind of ATM doesn't exchange money", standardATM.exchangeToEUR(account, 2));
    }

}
