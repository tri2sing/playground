package graphs;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class EvaluateDivisionTest {
    private EvaluateDivision calculator = new EvaluateDivision();

    @Test
    public void calcEquation() throws Exception {
        String[][] equations = new String[][] {{"a", "b"}, {"b", "c"}};
        double [] values = new double [] {2.0, 3.0};
        String[][] queries = new String[][] {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        double [] expected = new double[] {6.0, 0.5, -1.0, 1.0, -1.0};
        double [] result = calculator.calcEquation(equations, values, queries);
        assertThat(result).isEqualTo(expected);
    }


}
