package thinkbayes;

import java.util.List;

public class Euro extends SuiteNumeric<Integer, Float> {

    // Uniform prior
    public Euro(List<Integer> hypotheses) {
        super(hypotheses);
    }

    @Override
    public float getLikelihood(Float data, Integer hypothesis) {
        if (data == Flip.HEADS)
            return hypothesis.floatValue()/100F;
        else
            return 1 - (hypothesis.floatValue()/100F);
    }

}
