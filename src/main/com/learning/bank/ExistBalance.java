package main.com.learning.bank;

public class ExistBalance implements Balance {
    @Override
    public void showBalance(Account acc) {
        System.out.print("Your balance is: ");
        acc.showBalance();
    }
}
