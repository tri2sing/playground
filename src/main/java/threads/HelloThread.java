package threads;

public class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from thread subclass");
    }

    public static void main(String[] args) {
        new HelloThread().run();
    }
}
