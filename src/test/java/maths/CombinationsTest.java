package maths;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CombinationsTest {

    private <E> List<List<E>> arrayOfArraysToListofLists(E [][] array) {
        List<List<E>> ans = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            ans.add(Arrays.asList(array[i]));
        }
        return ans;
    }

    @Test
    public void integerCombinations() {
        Combinations<Integer> comb = new Combinations();
        List<Integer> input = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            input.add(i);
        }
        List<List<Integer>> result = comb.getCombinations(input, 3);
        Integer[][] expected = new Integer[][] {
                {0, 1, 2}, {0, 1, 3}, {0, 1, 4}, {0, 2, 3}, {0, 2, 4},
                {0, 3, 4}, {1, 2, 3}, {1, 2, 4}, {1, 3, 4}, {2, 3, 4},
        };
        assertThat(result).isEqualTo(arrayOfArraysToListofLists(expected));
    }

}
