package dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MinCoinCountForSumTest {
    @Test
    public void solveDynamic() throws Exception {
        int [] coinValues = new int [] {1, 3, 5};
        assertThat(MinCoinCountForSum.solveDynamic(7, coinValues)).isEqualTo(3D);
        assertThat(MinCoinCountForSum.solveDynamic(8, coinValues)).isEqualTo(2D);
        assertThat(MinCoinCountForSum.solveDynamic(9, coinValues)).isEqualTo(3D);
        assertThat(MinCoinCountForSum.solveDynamic(10, coinValues)).isEqualTo(2D);
        assertThat(MinCoinCountForSum.solveDynamic(11, coinValues)).isEqualTo(3D);
    }

    @Test
    public void solveRecursive() throws Exception {
        int [] coinValues = new int [] {1, 3, 5};
        assertThat(MinCoinCountForSum.solveRecursive(7, coinValues)).isEqualTo(3D);
        assertThat(MinCoinCountForSum.solveRecursive(8, coinValues)).isEqualTo(2D);
        assertThat(MinCoinCountForSum.solveRecursive(9, coinValues)).isEqualTo(3D);
        assertThat(MinCoinCountForSum.solveRecursive(10, coinValues)).isEqualTo(2D);
        assertThat(MinCoinCountForSum.solveRecursive(11, coinValues)).isEqualTo(3D);
    }

}
