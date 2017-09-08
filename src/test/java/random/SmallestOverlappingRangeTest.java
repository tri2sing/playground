package random;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SmallestOverlappingRangeTest {
    @Test
    public void test1() throws Exception {
        List<List<Integer>> input = new LinkedList<>();
        // The list returned by Arrays.asList does not support the remove operation.
        input.add(new LinkedList<>(Arrays.asList(4,10,15,24,26)));
        input.add(new LinkedList<>(Arrays.asList(0,9,12,20)));
        input.add(new LinkedList<>(Arrays.asList(5,18,22,30)));

        SmallestOverlappingRange sor = new SmallestOverlappingRange();
        int [] output = sor.smallestRange(input);
        int [] expected = new int[] {20, 24};
        assertThat(output).isEqualTo(expected);

    }

    @Test
    public void test2() throws Exception {
        List<List<Integer>> input = new LinkedList<>();
        // The list returned by Arrays.asList does not support the remove operation.
        input.add(new LinkedList<>(Arrays.asList(1, 2, 3)));
        input.add(new LinkedList<>(Arrays.asList(1, 2, 3)));
        input.add(new LinkedList<>(Arrays.asList(1, 2, 3)));

        SmallestOverlappingRange sor = new SmallestOverlappingRange();
        int [] output = sor.smallestRange(input);
        int [] expected = new int[] {1, 1};
        assertThat(output).isEqualTo(expected);

    }

}

