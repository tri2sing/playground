package maths;

import java.util.ArrayList;
import java.util.List;

public class PowerSetEnumerate {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(long i = 1; i < Math.pow(2, n); i++) {
            List<Integer> current = new ArrayList<>();
            long k = i;
            int index = 0;
            while(k > 0) {
                long r = k % 2;
                if(r == 1) { current.add(nums[index]); }
                ++index;
                k = k / 2;
            }
            result.add(current);
        }
        result.add(new ArrayList<>());
        return result;
    }
}
