package heaps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWordsAgain {
    public static class HeapNode implements Comparable<HeapNode> {
        String term;
        int freq;

        public HeapNode(String term, int freq) {
            this.term = term;
            this.freq = freq;
        }

        public int compareTo(HeapNode that) {
            return this.freq - that.freq;
        }

        public String getTerm() {
            return term;
        }

        public int getFreq() {
            return freq;
        }
    }

    public List<HeapNode> topK(String[] terms, int k) {
        Map<String, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            Integer frequency = frequencies.get(terms[i]);
            if (frequency == null) {
                frequency = new Integer(0);
            }
            frequencies.put(terms[i], frequency + 1);
        }

        Iterator<Map.Entry<String, Integer>> iter = frequencies.entrySet().iterator();
        PriorityQueue<HeapNode> heap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = iter.next();
            heap.add(new HeapNode(entry.getKey(), entry.getValue()));
        }

        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            HeapNode node = heap.peek();
            if (node.freq < entry.getValue()) {
                heap.poll();
                heap.add(new HeapNode(entry.getKey(), entry.getValue()));
            }
        }

        LinkedList<HeapNode> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            HeapNode node = heap.poll();
            deque.addFirst(node);
        }

        return deque;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"t4", "t1", "t1", "t1", "t2", "t2", "t3"};
        TopKFrequentWordsAgain s = new TopKFrequentWordsAgain();
        List<HeapNode> result = s.topK(input, 2);

        for (HeapNode node : result) {
            System.out.println(node.getTerm() + ": " + node.getFreq());
        }
    }


}
