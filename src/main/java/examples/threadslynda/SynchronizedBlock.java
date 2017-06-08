package examples.threadslynda;

public class SynchronizedBlock {
    public void printCountdown() {
        for (int i = 10; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + "    ----    " + i);
        }
        System.out.println(Thread.currentThread().getName() + "    ----    Blastoff!");
    }

    public static void main(String[] args) {
        SynchronizedBlock tsb = new SynchronizedBlock();
        Runnable runnable = () -> {
          synchronized (tsb) { // Prevent a blastoff from happening when another thread is counting down.
              tsb.printCountdown();
          }
        };
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
