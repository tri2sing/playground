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

public class ProbabilityMassFunction {
    private HashMap<String, Float> pmf; // probability mass function

    public ProbabilityMassFunction() {
        this.pmf = new HashMap<>();
    }

    public boolean hasEvent(String event) {
        return pmf.containsKey(event);
    }

    public void setEvent(String event, float frequency) {
        pmf.put(event, frequency);
    }

    public float getEvent(String event) {
        return pmf.get(event);
    }

    public Stream<String> getEventStream() {
        return pmf.keySet().stream();
    }

    public void normalize() {
        float valuesSum = pmf.values().stream().reduce(0F, Float::sum);
        pmf.replaceAll((k, v) -> v / valuesSum);
    }

    public void mult(String event, float multiplier) {
        pmf.put(event, pmf.getOrDefault(event, 0F) * multiplier);
    }

    @Override
    public String toString() {
        return pmf.toString();
    }
}

