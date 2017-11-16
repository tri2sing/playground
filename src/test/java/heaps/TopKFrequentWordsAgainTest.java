package heaps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;
import heaps.TopKFrequentWordsAgain.HeapNode;

import org.junit.Before;
import org.junit.Test;

public class TopKFrequentWordsAgainTest {
    private TopKFrequentWordsAgain tk = new TopKFrequentWordsAgain();

    @Test
    public void test1 () {
        String[] input = new String[]{"t4", "t1", "t1", "t1", "t2", "t2", "t3"};
        TopKFrequentWordsAgain s = new TopKFrequentWordsAgain();
        List<HeapNode> result = s.topK(input, 2);
        List<HeapNode> expected = new LinkedList<>();
        expected.add(new HeapNode("t1", 3));
        expected.add(new HeapNode("t2", 2));
        for(int i = 0; i < 2; i++) {
            assertThat(result.get(i).getTerm()).isEqualTo(expected.get(i).getTerm());
            assertThat(result.get(i).getFreq()).isEqualTo(expected.get(i).getFreq());
        }
    }
}
