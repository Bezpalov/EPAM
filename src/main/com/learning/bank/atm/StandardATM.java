package main.com.learning.bank.atm;

        import main.com.learning.bank.abilities.balance.ExistBalance;
        import main.com.learning.bank.abilities.charge.Charge;
        import main.com.learning.bank.abilities.exchange.NoExchange;

/**
 * Realization of ATM with abilities:
 * to put money, to get money, to show balance
 */
public class StandardATM extends ATM {

    public StandardATM() {
        balance = new ExistBalance();
        exchange = new NoExchange();
        charge = new Charge();
    }

    @Override
    public String toString() {
        return " from StandardATM";
    }
}
