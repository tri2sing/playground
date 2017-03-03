package thinkbayes;

import java.util.List;

public class MontyHallSuite extends Suite {
    private String doorUserChooses;
    private String doorMontyOpens;

    public MontyHallSuite(List<String> hypotheses) {
        super(hypotheses);
    }

    public void userChoosesDoor(String door) {
        doorUserChooses = door;
    }

    public void montyOpensDoor(String door) {
        doorMontyOpens = door;
    }

    @Override
    public float getLikelihood(String data, String hypothesis) {
        if(doorMontyOpens.equals(hypothesis))
            return 0F;
        else if (doorUserChooses.equals(hypothesis))
            return .5F;
        else
            return 1F;
    }
}
