package thinkbayes;

import java.util.List;

public class Locomotive extends Suite<Integer, Integer>{

    public Locomotive(List<Integer> hypotheses) {
        super(hypotheses, x -> {return 1F/x;});
    }

    @Override
    public float getLikelihood(Integer data, Integer hypothesis) {
        if (hypothesis < data) {
            return 0;
        } else {
            return 1.0F / hypothesis;
        }
    }
}
