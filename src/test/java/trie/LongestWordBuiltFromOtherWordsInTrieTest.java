package trie;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LongestWordBuiltFromOtherWordsInTrieTest {
    LongestWordBuiltFromOtherWordsInTrie lw;
    @Before
    public void setUp () {
        lw = new LongestWordBuiltFromOtherWordsInTrie();
    }

    @Test
    public void test1 () {
        String [] words = new String[] {"w","wo","wor","worl", "world"};
        assertThat(lw.longestWord(words)).isEqualTo("world");
    }

    @Test
    public void test2 () {
        String [] words = new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        assertThat(lw.longestWord(words)).isEqualTo("apple");
    }

    @Test
    public void test3 () {
        String [] words = new String[] {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"};
        assertThat(lw.longestWord(words)).isEqualTo("eyj");
    }
}
