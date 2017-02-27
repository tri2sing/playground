package thinkbayes;

import java.util.List;

public class Cookie extends ProbabilityMassFunction {

    public Cookie(List<String> hypotheses) {
        // forEach is terminal (void or non-stream result)
        hypotheses.stream() .forEach(x -> super.set(x, 1F));
        super.normalize();
    }
}
