package dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LongestNonDecreasingSequenceTest {
    @Test
    public void solveDynamic() throws Exception {
        int [] numbers = new int[] {5, 3, 4, 8, 6, 7};
        assertThat(LongestNonDecreasingSequence.solveDynamic(numbers)).isEqualTo(3D);
        numbers = new int[] {5, 3, 4, 8, 6, 7, 2, 3, 4, 5, 6, 2};
        assertThat(LongestNonDecreasingSequence.solveDynamic(numbers)).isEqualTo(5D);
    }

    @Test
    public void solveRecursive() throws Exception {
        int [] numbers = new int[] {5, 3, 4, 8, 6, 7};
        assertThat(LongestNonDecreasingSequence.solveRecursive(numbers)).isEqualTo(3D);
        numbers = new int[] {5, 3, 4, 8, 6, 7, 2, 3, 4, 5, 6, 2};
        assertThat(LongestNonDecreasingSequence.solveRecursive(numbers)).isEqualTo(5D);
    }
}
