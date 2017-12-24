package maths;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CombinationSumTest {

    @Test
    public void test1() throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 4);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(list);
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> result = cs.combinationSum3(3, 7);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test2() throws Exception {
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> list = Arrays.asList(1, 2, 6);
        expected.add(list);
        list = Arrays.asList(1, 3, 5);
        expected.add(list);
        list = Arrays.asList(2, 3, 4);
        expected.add(list);
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> result = cs.combinationSum3(3, 9);
        assertThat(result).isEqualTo(expected);
    }

}
