package name.adhikari.sameer.playground.lambdaswarburton;

public interface Greeter {
    public void greet();
    default public void defaultGreet(){
        System.out.println("Hi there!");
    }
}
