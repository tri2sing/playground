package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations<E> {

    private void getCombinations(int length, List<E> prefix, List<E> suffix, int k, List<List<E>> result) {
        if (prefix.size() == length) {
            List<E> inner = new ArrayList<>();
            inner.addAll(prefix);
            result.add(inner);
            return;
        }

        for (int i = 0; i < suffix.size(); i++) {
            prefix.add(suffix.get(i));
            List<E> remainder = new ArrayList<>();
            remainder.addAll(suffix.subList(i + 1, suffix.size()));
            getCombinations(length, prefix,  remainder, k - 1, result);
            prefix.remove(prefix.size() - 1);
        }
    }

    public List<List<E>> getCombinations(List<E> items, int r) {
        List<List<E>> result = new ArrayList<>();
        getCombinations(r, new ArrayList<>(), items, r, result);
        return result;
    }

    public void printResult(List<List<E>> results) {
        for (List<E> result : results) {
            System.out.println(Arrays.toString(result.toArray()));
        }
    }

}
