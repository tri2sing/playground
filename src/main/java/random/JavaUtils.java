package random;

import java.util.Arrays;
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
        while (iterator.hasNext()){
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

        while (pQueue.size() > 0){
            System.out.println(pQueue.poll());
        }
    }

    public static void main(String[] args) {
        priorityQueueInteger();
        priorityQueueString();
    }
}
