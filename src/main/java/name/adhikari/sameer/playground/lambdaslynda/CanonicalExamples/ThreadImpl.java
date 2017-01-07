package name.adhikari.sameer.playground.lambdaslynda.CanonicalExamples;

public class ThreadImpl {
    public static void main(String[] args) {
        // Annonymous inner class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Classical runnable");
            }
        };

        Runnable r2 = () -> System.out.println("Lamda runnable");

        r1.run();
        r2.run();

    }
}
