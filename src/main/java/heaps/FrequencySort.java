package heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    private class HeapNode {
        int key;
        char val;

        public HeapNode(int key, char val) {
            this.key = key;
            this.val = val;
        }
    }

    private class HeapNodeComparator implements Comparator<HeapNode> {
        @Override
        public int compare(HeapNode n1, HeapNode n2) {
            return n2.key - n1.key;
        }
    }

    public String frequencySort(String s) {
        if (s == null) return null;
        char[] array = s.toCharArray();
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer val = frequency.get(array[i]);
            if (val == null) {
                frequency.put(array[i], 1);
            } else {
                frequency.put(array[i], ++val);
            }
        }
        PriorityQueue<HeapNode> heap = new PriorityQueue(array.length, new HeapNodeComparator());
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            heap.add(new HeapNode(entry.getValue(), entry.getKey()));
        }
        int i = 0;
        while(!heap.isEmpty()) {
            HeapNode node = heap.poll();
            for (int j = 0; j < node.key; j++) {
                array[i++] = node.val;
            }
        }
        return String.valueOf(array);
    }
}
