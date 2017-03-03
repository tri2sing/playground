package thinkbayes;

import java.util.List;

/**
 * Class that represents a suite of hypothesis and their probabilities.
 */
public abstract class Suite extends ProbabilityMassFunction{
    public Suite (List<String> hypotheses) {
        super();
        hypotheses.stream().forEach(hypothesis -> setEvent(hypothesis, 1F));
        normalize();
    }

    /**
     * Update hypotheses given data
     * @param data
     */
    public void updateHypotheses(String data) {
        getEventStream().forEach(hypothesis -> {mult(hypothesis, getLikelihood(data, hypothesis));});
        normalize();
    }

    /**
     * Get likelihood of data under hypothesis
     */
    public abstract float getLikelihood(String data, String hypothesis);


}
