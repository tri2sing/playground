package name.adhikari.sameer.playground.generics;

import java.util.LinkedList;

/**
 * Created by samadhik on 12/18/16.
 */
public class GenericQueueBounded<T> {

    private LinkedList<T> list = new LinkedList<T>();

    public void enqueue (T item) {
        list.add(item);
    }

    public T dequeue () {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return (list.size() == 0);
    }

    public static void main(String[] args) {

        GenericQueueBounded<Character> charQueue = new GenericQueueBounded<>();
        for (char letter = 'a'; letter <= 'z'; letter++) {
            charQueue.enqueue(letter);
        }
        while (!charQueue.isEmpty()) {
            Character c = charQueue.dequeue();
            System.out.printf("%c, ", c);
        }
        System.out.println();

        GenericQueueBounded<Integer> intQueue = new GenericQueueBounded<>();
        for (int i = 1; i <= 26; i++) {
            intQueue.enqueue(i);
        }
        while (!intQueue.isEmpty()) {
            Integer i = intQueue.dequeue();
            System.out.printf("%d, ", i);
        }
    }
}
