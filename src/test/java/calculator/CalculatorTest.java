package calculator;

import static org.assertj.core.api.Assertions.*;

import calculator.*;
import calculator.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CalculatorTest {
    Expression left;
    Expression right;
    calculator.Number five;
    calculator.Number six;

    @BeforeEach
    public void setup() {
         left = new Sum(new calculator.Number(1), new calculator.Number(2));
         right = new Sum(new calculator.Number(4), new calculator.Number(5));
         five = new calculator.Number(5);
         six = new calculator.Number(6);
    }

    @Test
    public void should_sum_two_numbers() {
        // Arrange
        Expression sum = new Sum(five, six);

        // Act
        calculator.Number result = sum.evaluate();

        // Assert
        assertThat(result).isEqualTo(new calculator.Number(11));
    }

    @Test
    public void should_sum_two_expressions() {
        // Arrange
        Expression sum = new Sum(left, right);

        // Act
        calculator.Number result = sum.evaluate();

        // Assert
        assertThat(result).isEqualTo(new calculator.Number(12));
    }

    @Test
    public void should_multiply_two_numbers() {
        // Arrange
        Expression multiply = new Multiply(five, six);

        // Act
        calculator.Number result = multiply.evaluate();

        // Assert
        assertThat(result).isEqualTo(new calculator.Number(30));
    }

    @Test
    public void should_multiply_two_expressions() {
        // Arrange
        Expression multiply = new Multiply(left, right);

        // Act
        calculator.Number result = multiply.evaluate();

        // Assert
        assertThat(result).isEqualTo(new calculator.Number(27));
    }

    @Test
    public void should_divide_two_numbers() {
        // Arrange
        Expression division = new Division(new calculator.Number(4), new calculator.Number(2));

        // Act
        calculator.Number result = division.evaluate();

        // Assert
        assertThat(result).isEqualTo(new calculator.Number(2));
    }

    @Test
    public void should_fail_division_by_0() {
        // Arrange
        Expression division = new Division(new calculator.Number(4), new Number(0));

        // Act
        assertThatExceptionOfType(DivisionByZeroException.class)
                .isThrownBy(() -> division.evaluate())
                .withMessage("4 is not divisible by 0");
    }
}
