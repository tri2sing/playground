package thinkbayes;

import java.util.HashMap;

/**
 * <h1>Probablility Mass Function</h1>
 * This class represents a probability mass function.
 *
 * @author Sameer Adhikari
 * @version 1.0
 * @since 2017-02-20
 */

public class ProbabilityMassFunction {
    protected HashMap<String, Float> pmf; // probability mass function

    public ProbabilityMassFunction() {
        this.pmf = new HashMap<>();
    }

    public void set(String event, float frequency) {
        pmf.put(event, frequency);
    }

    public float get(String event) {
        return pmf.get(event);
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

