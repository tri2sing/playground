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
    private HashMap<String, Float> probabilityMassFunction; // probability mass function
    private float cumulativeFrequency; // Cumulative frequency

    public ProbabilityMassFunction() {
        this.probabilityMassFunction = new HashMap<>();
        this.cumulativeFrequency = 0f;
    }

    public void set(String event, float frequency) {
        this.cumulativeFrequency += frequency;
        probabilityMassFunction.put(event, frequency);
    }

    public float get(String event) {
        return probabilityMassFunction.get(event);
    }

    public void normalize() {
        if (cumulativeFrequency == 0) {
            throw new IllegalStateException("Cannot normalize when cumulative frequency is 0");
        }
        probabilityMassFunction.replaceAll((k, v) -> v/cumulativeFrequency);
        cumulativeFrequency = 1f;
    }

}

