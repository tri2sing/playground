package threads.buffer;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class BoundedBuffer<T> implements Buffer<T> {
    private int size;
    private int count = 0;
    private LinkedList<T> buffer = new LinkedList<>();
    private Semaphore mutex; // controls access to the buffer
    private Semaphore empty; // number of empty slots in the buffer
    private Semaphore full; // number of full slots in the buffer

    public BoundedBuffer(int size) {
        this.size = size;
        mutex = new Semaphore(1);
        empty = new Semaphore(size);
        full = new Semaphore(0);
    }

    @Override
    public void insert(T t) {
        try {
            empty.acquire(); // Track the number of empty elements
            mutex.acquire(); // Mutual exclusion on the buffer
            ++count;
            buffer.add(t);
            System.out.format("Thread %d inserted item. Current count = %d\n", Thread.currentThread().getId(), count);
            mutex.release();
            full.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public T remove() {
        T t = null;
        try {
            full.acquire();
            mutex.acquire();
            t = buffer.getFirst();
            --count;
            System.out.format("Thread %d removed item. Current count = %d\n", Thread.currentThread().getId(), count);
            mutex.release();
            empty.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return t;
    }
}
