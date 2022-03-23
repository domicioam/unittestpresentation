package bank;

public class AccountService {
    private final Presenter presenter;
    private final Calendar calendar;
    private Account account;
    private final AccountRepository accountRepository;

    public AccountService(Presenter presenter, Calendar calendar, Account account, AccountRepository accountRepository) {
        this.presenter = presenter;
        this.calendar = calendar;
        this.account = account;
        this.accountRepository = accountRepository;
    }

    public void deposit(int amount) {
        account = account.deposit(amount, calendar.getDate());
        accountRepository.save(account);
    }

    public void printStatement() {
        presenter.present(account.getStatements());
    }

    public void withdraw(int amount) {
        account = account.withdraw(amount, calendar.getDate());
        accountRepository.save(account);
    }
}
