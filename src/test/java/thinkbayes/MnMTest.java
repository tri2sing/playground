package thinkbayes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MnMTest {
    @Test
    public void testMnM() throws Exception {
        List<String> hypotheses = Arrays.asList(new String [] {"A", "B"});
        MnM mnm = new MnM(hypotheses);
        assertThat(mnm.getEvent("A")).isEqualTo(0.5F);
        assertThat(mnm.getEvent("B")).isEqualTo(0.5F);
        mnm.updateHypotheses("bag1 yellow");
        mnm.updateHypotheses("bag2 green");
        assertThat(mnm.getEvent("A")).isEqualTo(0.7407408f);
        // Used 0.7407408f instead of 20F/27F due to floating point precision issues.
        assertThat(mnm.getEvent("B")).isEqualTo(7F/27F);
    }

}
