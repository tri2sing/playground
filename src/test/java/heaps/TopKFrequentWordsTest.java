package heaps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TopKFrequentWordsTest {
    @Test
    public void test1() {
        TopKFrequentWords tkfw = new TopKFrequentWords();
        String [] input = new String[] {"i", "love", "code", "i", "love", "coding"};
        String [] expected = new String[] {"i", "love"};
        List<String> result = tkfw.topKFrequent(input, 2);
        assertThat(result).isEqualTo(Arrays.asList(expected));
    }
    @Test
    public void test2() {
        TopKFrequentWords tkfw = new TopKFrequentWords();
        String [] input = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String [] expected = new String[] {"the", "is", "sunny", "day"};
        List<String> result = tkfw.topKFrequent(input, 4);
        assertThat(result).isEqualTo(Arrays.asList(expected));
    }
}
