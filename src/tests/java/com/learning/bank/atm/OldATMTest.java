package com.learning.bank.atm;

import com.learning.bank.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class OldATMTest {
    OldATM oldATM;
    Account account;

    @Before
    public void init() {
        oldATM = new OldATM();
        account = Account.getAccount();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCashExceptionAccount() {
        oldATM.getCash(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCashExceptionMoney() {
        oldATM.getCash(account, 0);
    }

    @Test
    public void testGetCash() {
        account.putMoney(10);
        assertEquals("you have got 10.0RUB", oldATM.getCash(account, 10));
        assertEquals("There is no enough money on account", oldATM.getCash(account, 1000));
    }

    @Test
    public void testPutMoney() {
        assertEquals("This kind of ATM has no ability to deposit", oldATM.putMoney(account, 10));
    }

    @Test
    public void testExchangeToUSD() {
        Assert.assertEquals("This kind of ATM doesn't exchange money", oldATM.exchangeToUSD(account, 2));
    }

    @Test
    public void testExchangeToEUR() {
        Assert.assertEquals("This kind of ATM doesn't exchange money", oldATM.exchangeToEUR(account, 2));
    }
}
