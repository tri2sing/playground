package examples.waitandnotify;

public class Application {

    public static void main(String[] args) {
        int numProducers = 5;
        int numConsumers = 7;
        Queue queue = new Queue();
        Producer [] producers = new Producer[numProducers];
        Consumer [] consumers = new Consumer[numConsumers];

        for (int i = 0; i < numProducers; i++) {
            producers[i] = new Producer(queue);
            producers[i].start();
        }

        for (int i = 0; i < numConsumers; i++) {
            consumers[i] = new Consumer(queue);
            consumers[i].start();
        }
    }
}
