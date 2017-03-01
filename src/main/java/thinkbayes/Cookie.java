package thinkbayes;

import java.util.HashMap;
import java.util.List;

/**
 * A Cookie object maps hypothesis to their probabilities.
 *
 */

public class Cookie extends ProbabilityMassFunction {

    private HashMap<String, HashMap<String, Float>> mixes;

    // Gives each hypothesis the same prior probability
    public Cookie(List<String> bowls) {
        // forEach is terminal (void or non-stream result)
        bowls.stream().forEach(x -> super.set(x, 1F));
        super.normalize();
        mixes = new HashMap<>();
    }

    public void setDataUnderHypothesis(String bowl, HashMap<String, Float> mix) {
        if (super.contains(bowl)) {
            mixes.put(bowl, mix);
        } else {
            throw new IllegalArgumentException("Trying to set mix for a new bowl: " + bowl);
        }
    }

    public float getLikelihood(String bowl, String cookieType) {
        return mixes.get(bowl).get(cookieType);
    }

    public void update(String cookieType) {
        super.pmf.forEach((k, v) -> { super.mult(k, getLikelihood(k, cookieType)); } );
        super.normalize();
    }
}
