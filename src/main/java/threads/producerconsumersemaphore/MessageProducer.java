package threads.producerconsumersemaphore;

import java.util.Random;

public class MessageProducer implements Runnable {
    private MessageBox box;
    private Random random;

    public MessageProducer(MessageBox box) {
        this.box = box;
        random = new Random();
    }

    @Override
    public void run() {
        String[] messages = { "message 0", "message 1", "message 2", "message 3", };
        for (int i = 0; i < messages.length; i++) {
            box.put(messages[i]);
            System.out.format("created: %s\n", messages[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) { }
        }
        box.put("messages done");
    }
}
