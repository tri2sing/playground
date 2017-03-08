package thinkbayes;

import java.util.List;

/**
 * Class that represents a suite of hypothesis and their probabilities.
 */
public abstract class Suite<T> extends ProbabilityMassFunction{
    public Suite (List<T> hypotheses) {
        super();
        hypotheses.stream().forEach(hypothesis -> setEvent(hypothesis, 1F));
        normalize();
    }

    /**
     * Update hypotheses given data
     * @param data
     */
    public void updateHypotheses(T data) {
        getEventStream().forEach(hypothesis -> {mult(hypothesis, getLikelihood(data, (T) hypothesis));});
        normalize();
    }

    /**
     * Get likelihood of data under hypothesis
     */
    public abstract float getLikelihood(T data, T hypothesis);


}
