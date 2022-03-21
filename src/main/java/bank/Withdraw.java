package bank;

import java.time.LocalDate;

public record Withdraw(LocalDate date, int amount, int balance) implements Statement {
}
