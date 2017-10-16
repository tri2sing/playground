package maths;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PermutationsTest {

    private <E> List<List<E>> arrayOfArraysToListofLists(E [][] array) {
        List<List<E>> ans = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            ans.add(Arrays.asList(array[i]));
        }
        return ans;
    }

    @Test
    public void integerPermutations() {
        List<Integer> input = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            input.add(i);
        }
        Permutations<Integer> perm = new Permutations();
        List<List<Integer>> result = perm.getPermutations(input);
        Integer [][] expected = new Integer[][] { {0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 0 , 1}, {2, 1, 0},};
        assertThat(result).isEqualTo(arrayOfArraysToListofLists(expected));
    }

    @Test
    public void characterPermutations() {
        List<Character> input = new ArrayList<>();
        for(char i = 'a'; i < 'd'; i++) {
            input.add(i);
        }
        Permutations<Character> perm = new Permutations();
        List<List<Character>> result = perm.getPermutations(input);
        Character [][] expected = new Character[][] {
                {'a', 'b', 'c'}, {'a', 'c', 'b'},
                {'b', 'a', 'c'}, {'b', 'c', 'a'},
                {'c', 'a', 'b'}, {'c', 'b', 'a'}
        };
        assertThat(result).isEqualTo(arrayOfArraysToListofLists(expected));
    }

}
