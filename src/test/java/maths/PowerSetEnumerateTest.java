package maths;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PowerSetEnumerateTest {
    @Test
    public void test1() {
        PowerSetEnumerate ps = new PowerSetEnumerate();
        List<List<Integer>> result = ps.subsets(new int [] {1, 2});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test2() {
        PowerSetEnumerate ps = new PowerSetEnumerate();
        List<List<Integer>> result = ps.subsets(new int [] {1, 2, 3});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(1, 3));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(1, 2, 3));
        expected.add(Arrays.asList());
        assertThat(result).isEqualTo(expected);
    }

}
