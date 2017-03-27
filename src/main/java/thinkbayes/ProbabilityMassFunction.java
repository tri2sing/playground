package thinkbayes;

import java.util.HashMap;
import java.util.stream.Stream;

/**
 * <h1>Probablility Mass Function</h1>
 * This class represents a probability mass function.
 *
 * @author Sameer Adhikari
 * @version 1.0
 * @since 2017-02-20
 */

public class ProbabilityMassFunction<T> {
    private HashMap<T, Float> pmf; // probability mass function

    public ProbabilityMassFunction() {
        this.pmf = new HashMap<>();
    }

    public boolean hasEvent(T event) {
        return pmf.containsKey(event);
    }

    public void setEvent(T event, float frequency) {
        pmf.put(event, frequency);
    }

    public float getEvent(T event) {
        return pmf.get(event);
    }

    public Stream<T> getEventStream() {
        return pmf.keySet().stream();
    }

    public void normalize() {
        float valuesSum = pmf.values().stream().reduce(0F, Float::sum);
        pmf.replaceAll((k, v) -> v / valuesSum);
    }

    public T getMaximumLikelihoodEvent() {
        return pmf.entrySet().stream().max(
                (entry1, entry2) -> (entry1.getValue() > entry2.getValue() ? 1 : -1)
        ).get().getKey();

    }

    public float getMaximumLikelihoodValue() {
        return pmf.values().stream().max(Float::compareTo).get();
    }

    public void mult(T event, float multiplier) {
        pmf.put(event, pmf.getOrDefault(event, 0F) * multiplier);
    }

    @Override
    public String toString() {
        return pmf.toString();
    }
}

