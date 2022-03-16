import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void should_sum_two_numbers() {
        // Arrange
        Number a = new Number(5);
        Number b = new Number(6);
        Expression sum = new Sum(a, b);

        // Act
        Number result = sum.evaluate();

        // Assert
        assertThat(result).isEqualTo(new Number(11));
    }

    @Test
    public void should_sum_two_expressions() {
        // Arrange
        Expression left = new Sum(new Number(1), new Number(2));
        Expression right = new Sum(new Number(4), new Number(5));
        Expression sum = new Sum(left, right);

        // Act
        Number result = sum.evaluate();

        // Assert
        assertThat(result).isEqualTo(new Number(12));
    }

    @Test
    public void should_multiply_two_numbers() {
        // Arrange
        Number a = new Number(5);
        Number b = new Number(6);
        Expression multiply = new Multiply(a, b);

        // Act
        Number result = multiply.evaluate();

        // Assert
        assertThat(result).isEqualTo(new Number(30));
    }

    @Test
    public void should_multiply_two_expressions() {
        // Arrange
        Expression left = new Sum(new Number(1), new Number(2));
        Expression right = new Sum(new Number(4), new Number(5));
        Expression multiply = new Multiply(left, right);

        // Act
        Number result = multiply.evaluate();

        // Assert
        assertThat(result).isEqualTo(new Number(27));
    }
}
