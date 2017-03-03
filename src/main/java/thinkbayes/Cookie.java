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
        super();
        // forEach is terminal (void or non-stream result)
        bowls.stream().forEach(x -> setEvent(x, 1F));
        super.normalize();
        mixes = new HashMap<>();
    }

    public void setDataUnderHypothesis(String bowl, HashMap<String, Float> mix) {
        if (hasEvent(bowl)) {
            mixes.put(bowl, mix);
        } else {
            throw new IllegalArgumentException("Trying to setEvent mix for a new bowl: " + bowl);
        }
    }

    public float getLikelihood(String cookieType, String bowl) {
        return mixes.get(bowl).get(cookieType);
    }

    public void update(String cookieType) {
        getEventStream().forEach(k -> { mult(k, getLikelihood(cookieType, k)); } );
        normalize();
    }
}
