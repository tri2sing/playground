package graphs;

import java.util.*;

public class WordPathOneLetterDiff {
    private boolean isNeighbor(String word1, String word2) {
        int diff = 0;
        for(int i = 0; i < word1.length(); i++) { //both words have the same length
            if(word1.charAt(i) != word2.charAt(i)) {
                ++diff;
                if(diff > 1) return false;
            } else {
                continue;
            }
        }
        return true; // there are no duplicates
    }

    private Map<String, Set<String>> buildGraph(List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        int n = wordList.size();
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                String word1 = wordList.get(i);
                String word2 = wordList.get(j);
                if(isNeighbor(word1, word2));
                Set<String> set1 = graph.get(word1);
                Set<String> set2 = graph.get(word2);
                if(set1 == null) {
                    set1 = new HashSet<>();
                    graph.put(word1, set1);
                }
                if(set2 == null) {
                    set2 = new HashSet<>();
                    graph.put(word2, set2);
                }
                set1.add(word2);
                set2.add(word1);
            }
        }
        return graph;
    }

    private Queue<String> getNeighbors(String beginWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if(isNeighbor(beginWord, word)) queue.add(word);
        }
        return queue;

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> graph = buildGraph(wordList);
        Queue<String> queue = getNeighbors(beginWord, wordList);
        Set<String> visited = new HashSet<>();
        int distance = 0;

        while(!queue.isEmpty()) {
            Queue<String> current = new LinkedList<>();
            ++distance;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                System.out.println(word);
                if(word.equals(endWord)) {
                    return distance;
                }
                Set<String> neighbors = graph.get(word);
                if(neighbors != null && !visited.contains(word)) queue.addAll(neighbors);
                visited.add(word);
            }
        }
        return 0;
    }
}
