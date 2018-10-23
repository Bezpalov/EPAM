package main.com.learning.bank;

public abstract class ATM {

    public String getCash(Account acc, long money) {
        String result = "";
        try {
            result = acc.getMoney(money);
        }catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
