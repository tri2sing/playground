package heaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> frequencies = new HashMap<>();
            for(int i = 0; i < words.length; i++) {
                Integer frequency = frequencies.get(words[i]);
                if(frequency == null) {
                    frequencies.put(words[i], 1);
                }
                else {
                    frequencies.put(words[i], ++frequency);
                }
            }
            PriorityQueue<HeapNode> heap = new PriorityQueue<>();
            for(Map.Entry<String, Integer> entry : frequencies.entrySet()) {
                heap.add(new HeapNode(entry.getValue(), entry.getKey()));
            }
            List<String> result = new LinkedList<>();
            for(int i = 0; i < k; i++) {
                HeapNode node = heap.poll();
                result.add(node.word);
            }
            return result;
        }

        private class HeapNode implements Comparable<HeapNode> {
            private int frequency;
            private String word;

            public HeapNode(int frequency, String word) {
                this.frequency = frequency;
                this.word = word;
            }

            @Override
            public int compareTo(HeapNode other) {
                int diff = other.frequency - this.frequency;
                if (diff != 0) return diff;
                else return this.word.compareTo(other.word);
            }
        }
}
