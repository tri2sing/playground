package threads;

public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        String [] messages = {"msg 1", "msg 2", "msg 3", "msg 4"};
        for(int i = 0; i < messages.length; i++) {
            Thread.sleep(2000);
            System.out.println(messages[i]);
        }
    }
}
