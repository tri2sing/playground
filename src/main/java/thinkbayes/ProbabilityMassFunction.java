package thinkbayes;

import java.util.HashMap;

/**
 * <h1>Probablility Mass Function</h1>
 * This class represents a probability mass function.
 *
 * @author Sameer Adhikari
 * @version 1.0
 * @since 2017-02-20
 *
 */

public class ProbabilityMassFunction {
    private HashMap<String, Float> pmf; // probability mass function
    private float cf; // Cumulative frequency

    public ProbabilityMassFunction() {
        this.pmf = new HashMap<>();
        this.cf = 0f;
    }

    public void set(String event, float frequency) {
        this.cf += frequency;
        pmf.put(event, frequency);
    }

    public boolean contains(String event) {
        return pmf.containsKey(event);
    }

    public float get(String event) {
        return pmf.get(event);
    }

    public void normalize() {
        if (cf == 0) {
            throw new IllegalStateException("Cannot normalize when cumulative frequency is 0");
        }
        pmf.replaceAll((k, v) -> v/ cf);
        cf = 1f;
    }

    public void mult(String event, float multiplier) {
        pmf.put(event, pmf.getOrDefault(event, 0F) * multiplier);
    }

}

