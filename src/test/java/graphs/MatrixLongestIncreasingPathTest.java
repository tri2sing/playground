package graphs;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MatrixLongestIncreasingPathTest {
    @Test public void test1() {
        int [][] matrix = { {9,9,4}, {6,6,8}, {2,1,1} };
        MatrixLongestIncreasingPath mlip = new MatrixLongestIncreasingPath();
        assertThat(mlip.longestIncreasingPath(matrix)).isEqualTo(4);
    }

}

