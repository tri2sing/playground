package threads.buffer;

import java.util.Random;

public class BufferConsumer implements Runnable {
    private Buffer<Integer> buffer;

    public BufferConsumer(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(random.nextInt(5000));
                Integer result = buffer.remove();
                System.out.format("Thread %d, got item %d\n", Thread.currentThread().getId(), result);
            } catch (InterruptedException e) {
            }
        }
    }
}
