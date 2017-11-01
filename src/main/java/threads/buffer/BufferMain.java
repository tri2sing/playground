package threads.buffer;

public class BufferMain {
    public static void main(String[] args) {
        int numProducers = 5;
        int numConsumers = 3;
        int bufferSize = 10;

        Buffer<Integer> buffer = new BoundedBuffer<>(bufferSize);
        Thread[] producers = new Thread[numProducers];
        for (int i = 0; i < numProducers; i++) {
            producers[i] = new Thread(new BufferProducer(buffer));
        }
        Thread[] consumers = new Thread[numConsumers];
        for (int i = 0; i < numConsumers; i++) {
            consumers[i] = new Thread(new BufferConsumer(buffer));
        }
        for (int i = 0; i < numProducers; i++) {
            producers[i].start();
        }
        for (int i = 0; i < numConsumers; i++) {
            consumers[i].start();
        }
    }

}
