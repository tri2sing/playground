package stacks;

import java.util.*;

public class DistanceToNextLargerElement {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] days = new int[temperatures.length];
        Deque<Map.Entry<Integer, Integer>> stack = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++) {
            Map.Entry<Integer, Integer> next = stack.peekFirst();
            if(next != null && temperatures[i] > next.getKey()) {
                while (next != null && temperatures[i] > next.getKey()) {
                    Map.Entry<Integer, Integer> current = stack.pollFirst();
                    int index = current.getValue();
                    days[index] = i - index;
                    next = stack.peekFirst();
                }
            }
            stack.addFirst(new AbstractMap.SimpleEntry<Integer, Integer>(temperatures[i], i));
        }
        Map.Entry<Integer, Integer> current = stack.pollFirst();
        while(current != null) {
            days[current.getValue()] = 0;
            current = stack.pollFirst();
        }
        return days;
    }
}
