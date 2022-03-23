package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CalculatorTest {
    Expression left;
    Expression right;
    Number five;
    Number six;

    @BeforeEach
    public void setup() {
         left = new Sum(new Number(1), new Number(2));
         right = new Sum(new Number(4), new Number(5));
         five = new Number(5);
         six = new Number(6);
    }

    @Test
    public void should_sum_two_numbers() {
        // Given
        Expression five = new Number(5);
        Expression six = new Number(6);
        Expression sum = new Sum(five, six);

        // When
        Number result = sum.evaluate();

        // Then
        assertThat(result).isEqualTo(new Number(11));
    }

    @Test
    public void should_sum_two_expressions() {
        // Given
        Expression sum = new Sum(left, right);

        // When
        Number result = sum.evaluate();

        // Then
        assertThat(result).isEqualTo(new Number(12));
    }

    @Test
    public void should_multiply_two_numbers() {
        // Given
        Expression multiply = new Multiply(five, six);

        // When
        Number result = multiply.evaluate();

        // Then
        assertThat(result).isEqualTo(new Number(30));
    }

    @Test
    public void should_multiply_two_expressions() {
        // Given
        Expression multiply = new Multiply(left, right);

        // When
        Number result = multiply.evaluate();

        // Then
        assertThat(result).isEqualTo(new Number(27));
    }

    @Test
    public void should_divide_two_numbers() {
        Expression division = new Division(new Number(4), new Number(2));
        Number result = division.evaluate();

        assertThat(result).isEqualTo(new Number(2));
    }

    @Test
    public void should_fail_division_by_0() {
        Expression division = new Division(new Number(4), new Number(0));

        assertThatExceptionOfType(DivisionByZeroException.class)
                .isThrownBy(() -> division.evaluate())
                .withMessage("4 is not divisible by 0");
    }
}
