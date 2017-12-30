package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetBacktrack {
    private void backtrack(int [] nums, int start, List<List<Integer>> result, List<Integer> prefix) {
        result.add(new ArrayList<>(prefix));
        for(int i = start; i < nums.length; i++) {
            prefix.add(nums[i]);
            backtrack(nums, i + 1, result, prefix);
            prefix.remove(prefix.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }
}
