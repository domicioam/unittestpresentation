package bank;

import java.util.List;

public interface Presenter {
    void present(List<Statement> statements);

    List<Statement> statementList();
}
