package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * The basic idea is that for two strings s1 and s2:
 * 1. If s1(i) == s2(j) then lcs(i, j) = 1 + lcs(i - 1, j - 1)
 * 2. Else lcs(i, j) = max(lcs(i, j - 1), lcs(i - 1, j)
 */
public class LongestCommonSubsequence {

    private int memoization(char[] X, int i, char[] Y, int j, Map<int[], Integer> memo) {
        if (i < 0 || j < 0) {
            return 0;
        }
        int[] key = new int[]{i, j};
        if (memo.containsKey(key))
            return memo.get(key);

        if (X[i] == Y[j])
            return 1 + memoization(X, i - 1, Y, j - 1, memo);
        else
            return Math.max(
                    memoization(X, i, Y, j - 1, memo),
                    memoization(X, i - 1, Y, j, memo)
            );
    }

    public int memoization(String s1, String s2) {
        return memoization(s1.toCharArray(), s1.length() - 1, s2.toCharArray(), s2.length() - 1, new HashMap<>());
    }

    private int tabulation(char[] X, char[] Y) {
        int M = X.length, N = Y.length;
        int[][] table = new int[M + 1][N + 1];

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0)
                    table[i][j] = 0;    // i == 0 represent comparison of s2 against and empty string.
                    //j == 0 represents a comparison of s1 against an empty string.
                else if (X[i - 1] == Y[j - 1])
                    table[i][j] = 1 + table[i - 1][j - 1];
                else
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
            }
        }
        return table[M][N];
    }

    public int tabulation(String X, String Y) {
        return tabulation(X.toCharArray(), Y.toCharArray());
    }
}
