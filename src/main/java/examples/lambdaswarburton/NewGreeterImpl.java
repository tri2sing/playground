package examples.lambdaswarburton;

public class NewGreeterImpl implements Greeter {
    @Override
    public void greet() {
        System.out.println("Hi! I implement the old method from greeter.");
    }

    @Override
    public void defaultGreet() {
        System.out.println("I like to say Hello! instead of Hi!");
    }

    public static void main(String[] args) {
        NewGreeterImpl greeter = new NewGreeterImpl();
        greeter.defaultGreet();
        greeter.greet();
    }
}
