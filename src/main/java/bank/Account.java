package bank;

import java.time.LocalDate;
import java.util.List;

public class Account {
    private int iban;

    public Account(int iban) {
        this.iban = iban;
    }

    public Account deposit(int amount, LocalDate date) {
        return null;
    }

    public List<Statement> getStatements() {
        return null;
    }

    public Account withdraw(int amount, LocalDate date) {
        return null;
    }
}
