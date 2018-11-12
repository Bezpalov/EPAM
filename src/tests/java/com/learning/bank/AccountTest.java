package com.learning.bank;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountTest {
    Account account;

    @Before
    public void init() {
        account = Account.getAccount();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMoneyException() {
        account.getMoney(0);
    }

    @Test
    public void testGetMoney() {
        assertTrue(account.getMoney(1000).equals("There is no enough money on account"));
        assertTrue(account.getMoney(100000).equals("There is no enough money on account"));
        account.putMoney(100);
        assertEquals("you have got 80.0RUB", account.getMoney(80.0));
        assertEquals("you have got 20.0RUB", account.getMoney(20.0));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutMoneyException() {
        account.putMoney(0);
    }

    @Test
    public void testPutMoney() {
        assertTrue(account.putMoney(10.0).equals("10.0 RUB has been successfully deposited on account"));
        assertTrue(account.putMoney(100.0).equals("100.0 RUB has been successfully deposited on account"));
    }

    @Test
    public void testShowBalance() {
        BigDecimal initialBalance = account.showBalance();
        account.putMoney(100);
        initialBalance = initialBalance.add(BigDecimal.valueOf(100));
        assertTrue(account.showBalance().toString().equals(initialBalance.toString()));
    }
}
