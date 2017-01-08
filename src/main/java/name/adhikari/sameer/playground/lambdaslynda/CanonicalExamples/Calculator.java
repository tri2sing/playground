package name.adhikari.sameer.playground.lambdaslynda.CanonicalExamples;

@FunctionalInterface
public interface Calculator<T extends Number> {
    T calculate (T a, T b);
}
