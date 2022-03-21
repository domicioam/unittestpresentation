package calculator;

public record Number(int number) implements Expression {
    @Override
    public Number evaluate() {
        return this;
    }
}
