package threads;

public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from runnable implementation");
    }

    public static void main(String[] args) {
        new Thread(new HelloRunnable()).run();
    }
}
