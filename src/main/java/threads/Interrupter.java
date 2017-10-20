package threads;

public class Interrupter {
    private static void threadMessage(String message) {
        String name = Thread.currentThread().getName();
        System.out.format("%s: %s\n", name, message);
    }

    private static class Worker implements Runnable {
        @Override
        public void run() {
            boolean done = false;
            int iteration = 1;
            while (!done) {
                try {
                    Thread.sleep(3000);
                    threadMessage("in iteration " + iteration++);
                } catch (InterruptedException e) {
                    threadMessage("I got interrupted");
                    done = true;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // maximum wait before interrupting the worker.
        long maxWait = 1000 * 30; // half minute

        threadMessage("Staring worker");
        long startTime = System.currentTimeMillis();
        Thread worker = new Thread(new Worker());
        worker.start();
        while(worker.isAlive()){
            threadMessage("Waiting 5 secs for worker to exit");
            worker.join(5000);
            if (System.currentTimeMillis() - startTime > maxWait && worker.isAlive()) {
                worker.interrupt();
                worker.join();
            }
        }
        threadMessage("Finally done");
    }

}
