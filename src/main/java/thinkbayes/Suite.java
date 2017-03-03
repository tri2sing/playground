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
}
