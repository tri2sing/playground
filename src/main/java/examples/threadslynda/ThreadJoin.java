package examples.threadslynda;

public class ThreadJoin extends Thread {

    public ThreadJoin(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            System.out.println(Thread.currentThread().getName() + " completed iteration " + i);
        }
    }

    public static void main(String[] args) {
        ThreadJoin tj1 = new ThreadJoin("tj1");
        ThreadJoin tj2 = new ThreadJoin("tj2");
        ThreadJoin tj3 = new ThreadJoin("tj3");
        tj1.start();
        tj2.start();
        // Order of the join affects the output
        try{
            tj2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        tj3.start();
        try {
            tj3.join();
            tj1.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
