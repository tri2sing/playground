package examples.threadslynda;

public class SynchronizedMethod {
    private static int COUNTER = 1;

    public synchronized int getCounter() {
        return COUNTER++;
    }

    public static void main(String[] args) {
        Runnable runnable = () -> {
            SynchronizedMethod tSync = new SynchronizedMethod();
            for (int i = 0; i < 7; i++) {
                try {
                    Thread.sleep((long) (100 * (Math.random()) * 5 + 1));
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(Thread.currentThread().getName() + ": current counter value = " + tSync.getCounter());
            }
        };

        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(runnable, "Thread" + String.valueOf(i));
            threads[i].start();
        }
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }
}
