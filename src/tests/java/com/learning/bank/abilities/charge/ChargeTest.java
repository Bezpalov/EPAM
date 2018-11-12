package com.learning.bank.abilities.charge;

import com.learning.bank.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChargeTest {

    Account account;
    Charge charge;

    @Before
    public void init() {
        account = Account.getAccount();
        charge = new Charge();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositExceptionAccount() {
        charge.deposit(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositExceptionMoney() {
        charge.deposit(account, 0);
    }

    @Test
    public void testDeposit() {
        Assert.assertEquals("10.0 RUB has been successfully deposited on account", charge.deposit(account, 10));
    }
}
