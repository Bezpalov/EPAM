package com.learning.bank.abilities.exchange;

import com.learning.bank.Account;

import java.math.BigDecimal;

public class Exchange implements Exchangeable {
    private final BigDecimal usdCourse = BigDecimal.valueOf(65);
    private final BigDecimal eurCourse = BigDecimal.valueOf(80);

    @Override
    public String getUSD(Account acc, double usd) {
        if (acc == null) {
            throw new IllegalArgumentException("Account must exist");
        } else if (usd <= 0) {
            throw new IllegalArgumentException("Money must be more than zero");
        }

        BigDecimal usdToRub = usdCourse.multiply(BigDecimal.valueOf(usd));
        BigDecimal temp = acc.showBalance();
        String result = acc.getMoney(usdToRub.doubleValue());

        if (result.startsWith("you have")) {
            return "you are successfully received " + usd + " usd";
        } else if (result.startsWith("There is")) {
            return result;
        }
        return "unpredictable mistake";
    }

    @Override
    public String getEUR(Account acc, double eur) {
        if (acc == null) {
            throw new IllegalArgumentException("Account must exist");
        } else if (eur <= 0) {
            throw new IllegalArgumentException("Money must be more than zero");
        }

        BigDecimal eurToRub = eurCourse.multiply(BigDecimal.valueOf(eur));
        BigDecimal temp = acc.showBalance();
        String result = acc.getMoney(eurToRub.doubleValue());

        if (result.startsWith("you have")) {
            return "you are successfully received " + eur + " eur";
        } else if (result.startsWith("There is")) {
            return result;
        }
        return "unpredictable mistake";
    }
}
