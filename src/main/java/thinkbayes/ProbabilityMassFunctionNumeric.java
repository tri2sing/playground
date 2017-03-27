package thinkbayes;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * <h1>Probablility Mass Function Numeric</h1>
 * This class represents a probability mass function.
 * E is the type for events, and F is the type for frequency.
 *
 * @author Sameer Adhikari
 * @version 1.0
 * @since 2017-02-20
 */

public class ProbabilityMassFunctionNumeric<E extends Integer, F extends Float> {
    private TreeMap<E, F> pmf; // probability mass function

    public ProbabilityMassFunctionNumeric() {
        this.pmf = new TreeMap<>();
    }

    public boolean hasEvent(E event) {
        return pmf.containsKey(event);
    }

    public void setEvent(E event, F frequency) {
        pmf.put(event, frequency);
    }

    public F getEvent(E event) {
        return pmf.get(event);
    }

    public Stream<E> getEventStream() {
        return pmf.keySet().stream();
    }

    public void normalize() {
        float valuesSum = pmf.values().stream()
                .reduce(
                        (F) Float.valueOf(0F), (x, y) ->
                                (F) Float.valueOf(x.floatValue() + y.floatValue())
                );
        pmf.replaceAll((k, v) -> (F) Float.valueOf(v.floatValue() / valuesSum));
    }

    public void mult(E event, F multiplier) {
        F currentValue = pmf.getOrDefault(event, (F) Float.valueOf(0F));
        F newValue = (F) Float.valueOf(currentValue.floatValue() * multiplier.floatValue());
        pmf.put(event, newValue);
    }

    public F mean() {
        return pmf.entrySet().stream()
                .map(
                        es -> (F) Float.valueOf(
                                es.getKey().floatValue() * es.getValue().floatValue())
                )
                .reduce(
                        (F) Float.valueOf(0F), (x, y) ->
                                (F) Float.valueOf(x.floatValue() + y.floatValue())
                );
    }

    public E percentileEvent(Float percentileValue) {
        float percent = percentileValue.floatValue() / 100F;
        float runningTotal = 0;

        // TreeMap returs the value in order of the keys
        for (Map.Entry<E, F> entry : pmf.entrySet()) {
            runningTotal += entry.getValue().floatValue();
            if (runningTotal >= percent) {
                return entry.getKey();
            }
        }
        return null;
    }

    public E getMaximumLikelihoodEvent() {
        return pmf.entrySet().stream().max(
                (entry1, entry2)
                        -> (entry1.getValue().floatValue() > entry2.getValue().floatValue() ? 1 : -1)
        ) .get().getKey();
    }

    public F getMaximumLikelihoodValue() {
        return pmf.values().stream().max(Float::compareTo).get();
    }

    @Override
    public String toString() {
        return pmf.toString();
    }
}

