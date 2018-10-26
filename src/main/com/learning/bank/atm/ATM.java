package main.com.learning.bank.atm;

import main.com.learning.bank.Account;
import main.com.learning.bank.abilities.balance.Balance;
import main.com.learning.bank.abilities.charge.Chargeable;
import main.com.learning.bank.abilities.exchange.Exchangeable;

import java.math.BigDecimal;

public abstract class ATM implements Runnable{
     private static final Object mutex = new Object();

    protected Balance balance;
    protected Exchangeable exchange;
    protected Chargeable charge;

    public  String getCash(Account acc, double money) {
        String result = "";
        try {
            result = acc.getMoney(money);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public void getBalance(Account acc){
        balance.showBalance(acc);
    }

    public String putMoney(Account acc, double money) {
        return charge.deposit(acc, money);
    }

    public String exchangeToUSD (Account acc, double money) {
        return exchange.getUSD(acc, money);
    }

    public String exchangeToEUR (Account acc, double money) {
        return exchange.getEUR(acc, money);
    }


    @Override
    public void run() {
        Account acc = Account.getAccount();

        System.out.println(Thread.currentThread());
        System.out.println("Trying to put money");
        System.out.println(putMoney(acc, 100));
        System.out.println();

            do {

//                synchronized (mutex) {
                System.out.println(Thread.currentThread());
                getBalance(acc);
                System.out.println("Trying to get money" + toString());
                System.out.println(getCash(acc, 20));
                System.out.print("After operation ");
                getBalance(acc);
                System.out.println("Trying to get currency");
                System.out.println(exchangeToEUR(acc, 2));
                System.out.print("After exchange ");
                getBalance(acc);
                System.out.println();
//                }

            } while (acc.showBalance().compareTo(BigDecimal.ZERO) > 0);

    }
}
