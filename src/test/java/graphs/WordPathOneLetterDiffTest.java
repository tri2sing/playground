package graphs;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class WordPathOneLetterDiffTest {
    @Test
    public void test1() {
       List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
       String beginWord = "hit";
       String endWord = "cog";
       WordPathOneLetterDiff wp = new WordPathOneLetterDiff();
       assertThat(wp.ladderLength(beginWord, endWord, wordList)).isEqualTo(5);
        System.out.println();
    }

    @Test
    public void test2() {
        List<String> wordList = Arrays.asList("hot","dot","dog");
        String beginWord = "hot";
        String endWord = "dot";
        WordPathOneLetterDiff wp = new WordPathOneLetterDiff();
        assertThat(wp.ladderLength(beginWord, endWord, wordList)).isEqualTo(2);
        System.out.println();
    }

    @Test
    public void test3() {
        List<String> wordList = Arrays.asList("a","b","c");
        String beginWord = "a";
        String endWord = "c";
        WordPathOneLetterDiff wp = new WordPathOneLetterDiff();
        assertThat(wp.ladderLength(beginWord, endWord, wordList)).isEqualTo(2);
        System.out.println();
    }

}
