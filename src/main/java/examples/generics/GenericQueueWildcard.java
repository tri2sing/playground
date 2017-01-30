package examples.generics;

import java.util.Collection;
import java.util.LinkedList;

public class GenericQueueWildcard<T> {

    private LinkedList<T> list = new LinkedList<T>();

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return (list.size() == 0);
    }

    public void addAllFrom(Collection<? extends T> collection) {
        for (T item : collection) {
            enqueue(item);
        }
    }

    public void addAllTo(Collection<? super T> collection) {
        while (!isEmpty()) {
            T item = dequeue();
            collection.add(item);
        }
    }

    public static void main(String[] args) {

        GenericQueueWildcard<Character> charQueue = new GenericQueueWildcard<>();
        for (char letter = 'a'; letter <= 'z'; letter++) {
            charQueue.enqueue(letter);
        }
        while (!charQueue.isEmpty()) {
            Character c = charQueue.dequeue();
            System.out.printf("%c, ", c);
        }
        System.out.println();

        GenericQueueWildcard<Integer> intQueue = new GenericQueueWildcard<>();
        for (int i = 1; i <= 26; i++) {
            intQueue.enqueue(i);
        }
        while (!intQueue.isEmpty()) {
            Integer i = intQueue.dequeue();
            System.out.printf("%d, ", i);
        }
    }
}
