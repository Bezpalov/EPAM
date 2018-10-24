package main.com.learning.bank;

public class AbsenceBalance implements Balance {
    @Override
    public void showBalance(Account acc) {
        System.out.println("This kind of ATM doesn't maintain balance mapping");
    }
}
