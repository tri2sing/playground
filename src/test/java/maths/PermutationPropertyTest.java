package maths;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PermutationPropertyTest {
    @Test
    public void test1() {
        PermutationProperty ba = new PermutationProperty();
        assertThat(ba.countArrangement(2)).isEqualTo(2);
    }
}
