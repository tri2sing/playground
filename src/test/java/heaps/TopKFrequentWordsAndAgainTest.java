package heaps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TopKFrequentWordsAndAgainTest {
    private TopKFrequentWordsAndAgain tk = new TopKFrequentWordsAndAgain();

    @Test
    public void test1 () {
        String[] input = new String[]{"t4", "t1", "t1", "t1", "t2", "t2", "t3"};
        List<Map.Entry<String, Integer>> result = tk.topK(input, 2);
        List<Map.Entry<String, Integer>> expected = new LinkedList<>();
        expected.add(new AbstractMap.SimpleEntry("t1", 3));
        expected.add(new AbstractMap.SimpleEntry("t2", 2));
        for(int i = 0; i < 2; i++) {
            assertThat(result.get(i).getKey()).isEqualTo(expected.get(i).getKey());
            assertThat(result.get(i).getValue()).isEqualTo(expected.get(i).getValue());
        }

    }

}
