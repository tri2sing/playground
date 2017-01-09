package name.adhikari.sameer.playground.lambdaslynda.canonicalexamples;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate (T a, T b);
}
