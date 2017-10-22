package threads;

import java.util.Random;

public class MessageConsumer implements Runnable{
    private MessageBox box;
    private Random random;

    public MessageConsumer(MessageBox box) {
       this.box = box;
       random = new Random();
    }

    @Override
    public void run() {
        for(String message = box.take(); !message.equals("messages done"); message = box.take()) {
            System.out.format("received: %s\n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}
