package trie;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SumSubTriesTest {
    @Test
    public void test1() {
        SumSubTries trie = new SumSubTries();
        trie.insert("apple", 3);
        int result1 = trie.sum("ap");
        assertThat(result1).isEqualTo(3);
        trie.insert("ap", 2);
        int result2 = trie.sum("ap");
        assertThat(result2).isEqualTo(5);
    }

}
