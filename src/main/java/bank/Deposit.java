package bank;

import java.time.LocalDate;

public record Deposit(LocalDate date, int amount, int balance) implements Statement {
}
