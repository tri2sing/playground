package name.adhikari.sameer.playground.generics.animals;

public abstract class Animal {
    public void eat() {
        System.out.printf("%s eating\n", this.getClass().getSimpleName());
    }
}
