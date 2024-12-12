package ch04.tags.junit4;

import ch04.Calculator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JUnit4RuleExceptionTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private Calculator calculator = new Calculator();

    @Test
    public void expectIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("음수의 제곱근을 구할 수 없다");
        calculator.sqrt(-1);
    }
}