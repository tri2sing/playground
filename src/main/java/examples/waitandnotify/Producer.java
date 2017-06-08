package examples.waitandnotify;

import java.util.Date;

public class Producer extends Thread {
    Queue queue;
    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.putMessage(Thread.currentThread().getName() + " " + new Date().toString());
                sleep((long) (100 * (Math.random()) * 5 + 1));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
