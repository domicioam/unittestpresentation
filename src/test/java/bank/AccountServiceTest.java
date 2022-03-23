package bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountServiceTest {
    @Test
    public void printStatement() {
        // Given
        Presenter presenter = new TestPresenter();
        InMemoryRepository repository = new InMemoryRepository();

        Calendar calendar = new Calendar();
        LocalDate date = LocalDate.of(2012, 1, 10);
        calendar.setDate(date);

        Account account = new Account(12345);

        AccountService accountService = new AccountService(presenter, calendar, account, repository);
        accountService.deposit(10);
        accountService.deposit(10);
        accountService.withdraw(10);
        accountService.deposit(10);

        // When
        accountService.printStatement();

        // Then
        List<Statement> expected = Arrays.asList(
                new Deposit(date, 10, 10),
                new Deposit(date, 10, 20),
                new Withdraw(date, 10, 10),
                new Deposit(date, 10, 20));

        assertThat(presenter.statementList()).isEqualTo(expected);
        assertThat(repository.invokeCount).isEqualTo(4);
    }
}

