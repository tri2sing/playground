package threads.buffer;

import java.util.Random;

public class BufferProducer implements Runnable {
    private Buffer<Integer> buffer;

    public BufferProducer(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("Thread  " + Thread.currentThread().getId() + " starting");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(random.nextInt(5000));
                buffer.insert(i);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Thread  " + Thread.currentThread().getId() + " done");
    }
}
