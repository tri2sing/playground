package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations<E> {

    private void getPermutations (List<E> prefix, List<E> suffix, List<List<E>> result) {
        if(suffix.size() == 0) {
            List<E> inner = new ArrayList<>();
            inner.addAll(prefix);
            result.add(inner);
        }
        // Get the permutatios of size N - 1, and insert the cuurent
        // head element at different positions along the list.
        for(int i = 0; i < suffix.size(); i ++) {
            prefix.add(suffix.get(i));
            List<E> remainder = new ArrayList<>();
            remainder.addAll(suffix.subList(0, i));
            remainder.addAll(suffix.subList(i + 1, suffix.size()));
            getPermutations(prefix, remainder, result);
            prefix.remove(prefix.size() - 1);
        }
    }

    // Find all permutations of integers from 0 to N - 1
    public List<List<E>> getPermutations(List<E> integers) {
        List<List<E>> result = new ArrayList<>();
        List<E> prefix = new ArrayList<>();
        getPermutations(prefix, integers, result);
        return result;
    }

    public  void printResult(List<List<E>> results) {
        for (List<E> result : results) {
            System.out.println(Arrays.toString(result.toArray()));
        }
    }
}
