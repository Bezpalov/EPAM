package main.com.learning.bank.abilities.balance;

import main.com.learning.bank.Account;

public class ExistBalance implements Balance {
    @Override
    public void showBalance(Account acc) {
        System.out.println("Your balance is: " + acc.showBalance());
    }
}
