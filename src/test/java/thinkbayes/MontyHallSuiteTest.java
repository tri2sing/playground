package thinkbayes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MontyHallSuiteTest {

    @Test
    public void testMontyHall() throws Exception {
        List<String> doors = Arrays.asList("A", "B", "C");
        MontyHallSuite mh = new MontyHallSuite(doors);
        assertThat(mh.getEvent("A")).isEqualTo(1F/3F);
        assertThat(mh.getEvent("C")).isEqualTo(1F/3F);
        mh.userChoosesDoor("A");
        mh.montyOpensDoor("C");
        mh.updateHypotheses("C");
        assertThat(mh.getEvent("A")).isEqualTo(1F/3F);
        assertThat(mh.getEvent("B")).isEqualTo(2F/3F);
        assertThat(mh.getEvent("C")).isEqualTo(0);
    }

}
