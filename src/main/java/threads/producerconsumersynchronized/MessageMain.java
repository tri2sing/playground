package threads.producerconsumersynchronized;

public class MessageMain {
    public static void main(String[] args) {
        MessageBox box = new MessageBox();
        new Thread((new MessageProducer(box))).start();
        new Thread((new MessageConsumer(box))).start();
    }
}
