package thinkbayes;

import java.util.List;

public class Euro extends Suite<Integer, Flip> {

    // Uniform prior
    public Euro(List<Integer> hypotheses) {
        super(hypotheses);
    }

    @Override
    public float getLikelihood(Flip data, Integer hypothesis) {
        if (data == Flip.HEADS)
            return hypothesis.floatValue()/100F;
        else
            return 1 - (hypothesis.floatValue()/100F);
    }
}
