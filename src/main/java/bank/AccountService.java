package bank;

public class AccountService {
    private Presenter presenter;
    private Calendar calendar;
    private Account account;

    public AccountService(Presenter presenter, Calendar calendar, Account account) {
        this.presenter = presenter;
        this.calendar = calendar;
        this.account = account;
    }

    public void deposit(int amount) {
        account = account.deposit(amount, calendar.getDate());
    }

    public void printStatement() {
        presenter.present(account.getStatements());
    }

    public void withdraw(int amount) {
        account = account.withdraw(amount, calendar.getDate());
    }
}
