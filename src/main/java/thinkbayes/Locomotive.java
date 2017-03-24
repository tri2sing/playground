package thinkbayes;

import java.util.List;

public class Locomotive<H extends Integer, D extends Float> extends SuiteNumeric{

    public Locomotive(List<H> hypotheses) {
        super(hypotheses, x -> 1F/ ((Integer) x).floatValue());
    }

    @Override
    public float getLikelihood(Float data, Integer hypothesis) {
        if (hypothesis < data) {
            return 0;
        } else {
            return 1.0F / hypothesis;
        }
    }
}
