package thinkbayes;

import java.util.List;
import java.util.function.Function;

/**
 * Class that represents a suite of hypothesis and their probabilities.
 */
public abstract class SuiteNumeric<H extends Integer, D extends Float> extends ProbabilityMassFunctionNumeric {
    public SuiteNumeric(List<H> hypotheses) {
        super();
        hypotheses.stream().forEach(hypothesis -> setEvent(hypothesis, 1F));
        normalize();
    }

    public SuiteNumeric(List<H> hypotheses, Function<H, D> frequencyDistributionFunction) {
        super();
        hypotheses.stream().forEach(hypothesis ->
                setEvent(hypothesis, frequencyDistributionFunction.apply(hypothesis)));
        normalize();
    }

    public SuiteNumeric(List<H> hypotheses, Prior prior) {
        super();
        hypotheses.stream().forEach(hypothesis ->
                setEvent(hypothesis, prior.apply( hypothesis.floatValue())));
        normalize();
    }

    /**
     * Update hypotheses given data
     */
    public void updateHypotheses(D data) {
        getEventStream().forEach(hypothesis -> {
            multiply((Integer) hypothesis, getLikelihood(data, (H) hypothesis));
        });
        normalize();
    }

    /**
     * Get likelihood of data under hypothesis
     */
    public abstract float getLikelihood(D data, H hypothesis);


}
