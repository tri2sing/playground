package name.adhikari.sameer.playground.lambdaswarburton;

public class OldGreeterImpl implements Greeter {
    @Override
    public void greet() {
        System.out.println("Hi! I implement the one method in Greeter");
    }

    public static void main(String[] args) {
        OldGreeterImpl greeter = new OldGreeterImpl();
        greeter.greet();
    }
}
