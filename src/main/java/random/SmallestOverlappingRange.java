package random;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestOverlappingRange {

    private static class NumToList implements Comparable<NumToList>{
        private int num;
        private int list;

        public NumToList(int num, int list) {
            this.num = num;
            this.list = list;
        }

        @Override
        public int compareTo(NumToList that) {
            return this.num - that.num;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int [] result = new int[2];
        PriorityQueue<NumToList> heap = new PriorityQueue<>();
        // Initialize the heap with one value from each list.
        for(int i = 0; i < nums.size(); i++){
            heap.add(new NumToList(nums.get(i).remove(0), i));
        }
        NumToList current = null;
        while(true){
            current = heap.poll();
            if(nums.get(current.list).isEmpty()) {
                result[0] = current.num;
                break; // If one of the lists is empty.
            }
            heap.add(new NumToList(nums.get(current.list).remove(0), current.list));
        }
        for(int i = 0; i < nums.size() - 1; i++) {
            current = heap.poll();
        }
        result[1] = current.num;

        return result;
    }

}
