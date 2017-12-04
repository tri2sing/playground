package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * A binomial coefficient C(n, k) is the coefficient of x^k in the expansion of (1 + x)^n.
 * It gives the number of k-element subsets of n-element set, that is the number of ways
 * that k objects can be chosen from n elements disregarding order.
 * <p>
 * The mathematical formula is C(n, k) = C(n - 1, k - 1) + C(n - 1, k), where C(n, 0) = C(n, n) = 1.
 */

public class BinomialCoefficient {

    private int memoization(int n, int k, Map<int[], Integer> memo) {
        int[] key = new int[]{n, k};
        if (k == 0 || n == k) {
            memo.put(key, 1);
            return 1;
        }
        if (memo.containsKey(key))
            return memo.get(key);

        int result = memoization(n - 1, k - 1, memo) + memoization(n - 1, k, memo);
        memo.put(key, result);
        return result;
    }

    public int memoization(int n, int k) {
        Map<int [], Integer> memo = new HashMap<>();
        return memoization(n, k, memo);
    }

    public int tabulation(int n, int k) {
        int [][] table = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || i == j) {
                    table[i][j] = 1;
                }
                else {
                    table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
                }
            }
        }
        return table[n][k];
    }
}
