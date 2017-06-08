package examples.waitandnotify;

public class Consumer extends Thread {
    Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + ": got message = " + queue.getMessage());
                sleep((long) (100 * (Math.random()) * 5 + 1));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

}
