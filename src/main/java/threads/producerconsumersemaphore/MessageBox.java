package threads.producerconsumersemaphore;

import java.util.concurrent.Semaphore;

public class MessageBox {
    // To guarantee that we start with the producer we set
    // the permits accordingly in the producer and consumer
    private Semaphore producer = new Semaphore(1);
    private Semaphore consumer = new Semaphore(0);

    private String message;

    public void put(String message){
        try {
            producer.acquire();
            this.message = message;
            consumer.release();
        } catch (InterruptedException e) {
        }
    }

    public String take() {
        String result = null;
        try {
            consumer.acquire();
            result = this.message;
            producer.release();
        } catch (InterruptedException e) {
        }
        return result;
    }
}
