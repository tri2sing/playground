package random;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class MathExpressionStringFormTest {
    @Test
    public void tokenize() throws Exception {
        String expression = "1 + 2 * 3";
        String[] expected = new String[] {"1", "+", "2", "*", "3"};
        List<String> result = MathExpressionStringForm.tokenize(expression);
        assertThat(result.toArray()).isEqualTo(expected);
    }

}
