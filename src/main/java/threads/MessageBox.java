package threads;

public class MessageBox {
    private String message; // sent from producer to consumer.
    private boolean empty = true; // for efficieny; avoids the need to make copies.

    public synchronized void put(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        empty = false; // toggle status
        this.message = message;
        notifyAll(); // signal the waiting consumers
    }

    public synchronized String take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        empty = true;
        String result = message;
        notifyAll();
        return result; // signal the waiting producers
    }

}
