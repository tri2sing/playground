package dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SubArrayArithmeticProgressionsTest {
    @Test public void test1() {
        SubArrayArithmeticProgressions saps = new SubArrayArithmeticProgressions();
        int [] A = new int[] {1, 2, 3, 4};
        assertThat(saps.numberOfArithmeticSlices(A)).isEqualTo(3);
    }
}
