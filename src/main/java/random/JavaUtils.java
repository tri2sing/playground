package random;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

public class JavaUtils {
    public static void priorityQueueInteger() {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        pQueue.add(5);
        pQueue.add(4);
        pQueue.add(3);
        pQueue.add(2);
        pQueue.add(1);

        Iterator<Integer> iterator = pQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(pQueue.poll());
        }
    }

    public static void priorityQueueString() {
        PriorityQueue<String> pQueue = new PriorityQueue<>();

        pQueue.add("zyx");
        pQueue.add("wvu");
        pQueue.add("tsr");
        pQueue.add("qpo");
        pQueue.add("nml");

        while (pQueue.size() > 0) {
            System.out.println(pQueue.poll());
        }
    }

    public static void HashMapWithPriorityQueue() {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        map.put("A", new PriorityQueue<>());
        PriorityQueue pQ = map.get("A");
        for (int i = 4; i >= 0; i--) {
            pQ = map.get("A");
            pQ.add(String.valueOf(i));
        }
        pQ = map.get("A");
        while (pQ.size() > 0) {
            System.out.println(pQ.poll());
        }

    }

    public static void useEmptyStrings() {
        String [] s1 = new String[] {""};
        String [] s2 = new String [] {"A", "B"};
        System.out.println("empty array = " + s1);
        System.out.println("non-empty array = " + s2);
    }

    public static void main(String[] args) {
        //priorityQueueInteger();
        //priorityQueueString();
        HashMapWithPriorityQueue();
    }
}
