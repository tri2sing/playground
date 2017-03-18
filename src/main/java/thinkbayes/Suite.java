package thinkbayes;

import java.util.List;

/**
 * Class that represents a suite of hypothesis and their probabilities.
 */
public abstract class Suite<H, D> extends ProbabilityMassFunction{
    public Suite (List<H> hypotheses) {
        super();
        hypotheses.stream().forEach(hypothesis -> setEvent(hypothesis, 1F));
        normalize();
    }

    /**
     * Update hypotheses given data
     * @param data
     */
    public void updateHypotheses(D data) {
        getEventStream().forEach(hypothesis -> {mult(hypothesis, getLikelihood(data, (H) hypothesis));});
        normalize();
    }

    /**
     * Get likelihood of data under hypothesis
     */
    public abstract float getLikelihood(D data, H hypothesis);


}
