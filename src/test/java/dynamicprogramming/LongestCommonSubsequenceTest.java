package dynamicprogramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LongestCommonSubsequenceTest {
    @Test
    public void memoization() throws Exception {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        assertThat(lcs.memoization("AGGTAB", "GXTXAYB")).isEqualTo(4);
    }

    @Test
    public void tabulation() throws Exception {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        assertThat(lcs.tabulation("AGGTAB", "GXTXAYB")).isEqualTo(4);
    }


}
