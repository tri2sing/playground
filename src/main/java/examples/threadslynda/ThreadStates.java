package examples.threadslynda;

public class ThreadStates {
    public static void printState(Thread thread) {
        printState(thread.getName(), thread.isAlive(), thread.getState().name(), thread.getPriority());
    }

    public static void printState(String name, boolean isAlive, String state, int priority) {
        System.out.printf("%s is %salive and in %s state with priority %d\n",
                name, isAlive ? "" : "not ", state, priority);
    }

    public static void main(String[] args) throws InterruptedException{
        printState(Thread.currentThread());

        Runnable runnable = () -> {
          Thread thread = Thread.currentThread();
          printState(thread);
        };
        Thread thread1 = new Thread(runnable, "Thread thread1");
        printState(thread1);

        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread.sleep(2000);
        thread2.setName("Thread thread2");
        printState(thread2);

        printState(Thread.currentThread());
    }
}
