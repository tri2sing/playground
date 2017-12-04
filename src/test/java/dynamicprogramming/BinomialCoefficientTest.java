package dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BinomialCoefficientTest {

    @Test
    public void testMemoization() {
        BinomialCoefficient bc = new BinomialCoefficient();
        assertThat(bc.memoization(5, 2)).isEqualTo(10);
        assertThat(bc.memoization(6, 2)).isEqualTo(15);
    }

    @Test
    public void testTabulation() {
        BinomialCoefficient bc = new BinomialCoefficient();
        assertThat(bc.tabulation(5, 2)).isEqualTo(10);
        assertThat(bc.tabulation(6, 2)).isEqualTo(15);
    }
}
