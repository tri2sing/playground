package examples.lambdaswarburton;

public interface Greeter {
    void greet();

    // Additional method in interface added over time.
    // The default keyword makes it compatible with older
    // implementations that implement only the greet method.
    default void defaultGreet(){
        System.out.println("Hi there!");
    }
}
