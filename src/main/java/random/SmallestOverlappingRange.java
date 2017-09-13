package random;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestOverlappingRange {

    private static class NumToList implements Comparable<NumToList>{
        private int val;
        private int list;

        public NumToList(int val, int list) {
            this.val = val;
            this.list = list;
        }

        @Override
        public int compareTo(NumToList that) {
            return this.val - that.val;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int heapMin, heapMax = Integer.MIN_VALUE;
        int range, rangeLeft, rangeRight;

        PriorityQueue<NumToList> heap = new PriorityQueue<>();
        // Initialize the heap with one value from each list.
        for(int i = 0; i < nums.size(); i++){
            int val = nums.get(i).remove(0);
            heap.add(new NumToList(val, i));
            heapMax = Math.max(heapMax, val);
        }
        heapMin = heap.peek().val; // Top of the heap
        range = heapMax - heapMin;
        rangeLeft = heapMin;
        rangeRight = heapMax;


        NumToList current = null;
        while(true){
            current = heap.poll();
            if(nums.get(current.list).isEmpty()) {
                break; // When we reach the first empty list.
            }
            int next = nums.get(current.list).remove(0);
            heap.add(new NumToList(next, current.list));
            int nextMax = Math.max(heapMax, next);
            int nextMin = heap.peek().val;
            if(nextMax - nextMin < range) {
                range = nextMax - nextMin;
                rangeLeft = nextMin;
                rangeRight = nextMax;
            }
            heapMax = nextMax;
            heapMin = nextMin;
        }
        return new int[] {rangeLeft, rangeRight};
    }

}
