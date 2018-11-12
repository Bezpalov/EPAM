package com.learning.bank.abilities.exchange;

import com.learning.bank.Account;

/**
 * Interface that gives an opportunity to exchange currency
 */
public interface Exchangeable {

    /**
     * @param acc account of exchange
     * @param usd amount of currency to exchange
     * @return String representation of result of operation
     */
    String getUSD(Account acc, double usd);

    /**
     * @param acc account of exchange
     * @param eur amount of currency to exchange
     * @return String representation of result of operation
     */
    String getEUR(Account acc, double eur);
}
