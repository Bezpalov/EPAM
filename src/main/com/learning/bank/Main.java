package main.com.learning.bank;

import main.com.learning.bank.atm.ATM;
import main.com.learning.bank.atm.AdvancedATM;
import main.com.learning.bank.atm.OldATM;
import main.com.learning.bank.atm.StandartATM;

public class Main {
    public static void main(String[] args) {
        OldATM oldATM = new OldATM();
        ATM standartATM = new StandartATM();
        AdvancedATM advancedATM = new AdvancedATM();

        advancedATM.getBalance(Account.getInstance());
        advancedATM.

    }
}
