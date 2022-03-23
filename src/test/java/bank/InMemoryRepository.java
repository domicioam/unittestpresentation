package bank;

public class InMemoryRepository implements AccountRepository {

    public int invokeCount;
    @Override
    public void save(Account account) {
        invokeCount++;
    }
}
