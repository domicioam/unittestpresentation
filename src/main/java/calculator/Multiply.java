package calculator;

public record Multiply(Expression left, Expression right) implements Expression {
    @Override
    public Number evaluate() {
        return loop(left, right);
    }

    private Number loop(Expression left, Expression right) {
        if(left instanceof Number a && right instanceof Number b) {
            return new Number(a.number() * b.number());
        }

        return loop(left.evaluate(), right.evaluate());
    }
}
