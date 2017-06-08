package examples.waitandnotify;

import java.util.Vector;

public class Queue {
    private static final int QUEUE_LIMIT = 5;
    private Vector<String> messages = new Vector<>();

    public synchronized void putMessage(String message) throws InterruptedException {
        while (messages.size() == QUEUE_LIMIT) {
            wait();
        }
        messages.add(message);
        System.out.println(Thread.currentThread().getName() + " put message = " + message);
        notify();
    }

    public synchronized String getMessage() throws InterruptedException {
        while (messages.size() == 0) {
            wait();
        }
        String message = messages.get(0);
        messages.remove(0);
        notify();
        return message;
    }
}
