package com.learning.bank;

import com.learning.bank.atm.ATM;
import com.learning.bank.atm.AdvancedATM;
import com.learning.bank.atm.OldATM;
import com.learning.bank.atm.StandardATM;

public class Main {

    public static void main(String[] args) {
        ATM[] atms = new Main().getATMs();
        for (int i = 0; i < atms.length; i++) {
            new Thread(atms[i]).start();
        }
    }

    /**
     * @return number of various type of ATMs
     */
    public ATM[] getATMs() {
        return new ATM[]{new OldATM(), new StandardATM(), new AdvancedATM()};
    }
}
