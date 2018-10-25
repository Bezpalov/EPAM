package main.com.learning.bank.balance;

import main.com.learning.bank.Account;

public class ExistBalance implements Balance {

    @Override
    public void showBalance(Account acc) {
        System.out.print("Your balance is: ");
        System.out.println(acc.showBalance());
    }
}
