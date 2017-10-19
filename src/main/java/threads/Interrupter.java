package threads;

public class Interrupter {
    private static void threadMessage(String message) {
        String name = Thread.currentThread().getName();
        System.out.format("%s: %s\n", name, message);
    }

    private static class Worker implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                threadMessage("I got interrupted");
            }
        }
    }

}
