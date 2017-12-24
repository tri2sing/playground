package maths;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers
 * from 1 to 9 can be used and each combination should be a unique set of numbers.
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]

 * Example 2:
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */

public class CombinationSum {

    List<List<Integer>>  result;

    private void combinationSum3(int [] input, int start, int target, int k, List<Integer> prefix) {
        if(k == 0 && target == 0) {
            result.add(new ArrayList<>(prefix));
        }
        else {
            for(int i = start; i < input.length && target > 0 && k > 0 ; i++) {
                prefix.add(input[i]);
                combinationSum3(input, i + 1, target - input[i], k - 1, prefix);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        int [] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        combinationSum3(input, 0, n, k, new ArrayList<>());
        return result;
    }
}
