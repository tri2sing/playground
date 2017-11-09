package heaps;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Condition;
import org.junit.Test;

public class FrequencySortTest {
    @Test
    public void test1() {
        FrequencySort fs = new FrequencySort();
        assertThat(fs.frequencySort("tree")).isEqualTo("eert");
    }

    @Test
    public void test2() {
        FrequencySort fs = new FrequencySort();
        assertThat(fs.frequencySort("cccaaa")).isEqualTo("aaaccc");
    }

}
