package thinkbayes;

import java.util.List;

public class Dice extends Suite<Integer, Integer> {
    public Dice(List<Integer> hypotheses) {
        super(hypotheses);
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
