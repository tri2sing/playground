package stacks;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DistanceToNextLargerElementTest {
    @Test
    public void test1() {
        DistanceToNextLargerElement dnle = new DistanceToNextLargerElement();
        int [] input = new int[] {73,74,75,71,69,72,76,73};
        int [] expected = new int[] {1,1,4,2,1,1,0,0};
        int [] result = dnle.dailyTemperatures(input);
        assertThat(result).isEqualTo(expected);
    }

}
