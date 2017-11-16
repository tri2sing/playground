package heaps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWordsAndAgain {
    public List<Map.Entry<String, Integer>> topK(String[] terms, int k) {
        Map<String, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            Integer frequency = frequencies.get(terms[i]);
            if (frequency == null) {
                frequency = new Integer(0);
            }
            frequencies.put(terms[i], frequency + 1);
        }

        Iterator<Map.Entry<String, Integer>> iter = frequencies.entrySet().iterator();
        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(k,
                (Map.Entry<String, Integer>o1, Map.Entry<String, Integer>o2) -> o1.getValue() - o2.getValue()
        );
        for (int i = 0; i < k; i++) {
            heap.add(iter.next());
        }

        while (iter.hasNext()) {
            Map.Entry<String, Integer> hashMapNode = iter.next();
            Map.Entry<String, Integer> heapNode = heap.peek();
            if (heapNode.getValue() < hashMapNode.getValue()) {
                heap.poll();
                heap.add(hashMapNode);
            }
        }

        LinkedList<Map.Entry<String, Integer>> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry node = heap.poll();
            result.addFirst(node);
        }
        return result;
    }
}
