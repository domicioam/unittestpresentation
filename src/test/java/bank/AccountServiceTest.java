package bank;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountServiceTest {
    @Test
    public void printStatement() {
        // Arrange
        Presenter presenter = new TestPresenter();
        LocalDate date = LocalDate.of(2012, 1, 10);
        Calendar calendar = new Calendar();
        calendar.setDate(date);
        AccountService accountService = new AccountService(presenter, calendar, new Account());

        accountService.deposit(10);
        accountService.deposit(10);
        accountService.withdraw(10);
        accountService.deposit(10);

        // Act
        accountService.printStatement();

        // Assert
        List<Statement> expected = Arrays.asList(new Deposit(date, 10, 10), new Deposit(date, 10, 20), new Withdraw(date, 10, 10), new Deposit(date, 10, 20));
        assertThat(presenter.statementList()).isEqualTo(expected);
    }

    private class TestPresenter implements Presenter {
        @Override
        public void present(List<Statement> statements) {

        }

        @Override
        public List<Statement> statementList() {
            return null;
        }
    }
}
