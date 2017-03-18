package thinkbayes;

import java.util.HashMap;
import java.util.List;

public class MnM extends Suite<String, String> {
    private static final HashMap<String, Float> MIX1994 = new HashMap<>();
    static {
        MIX1994.put("brown", 30F);
        MIX1994.put("yellow", 20F);
        MIX1994.put("red", 20F);
        MIX1994.put("green", 10F);
        MIX1994.put("orange", 10F);
        MIX1994.put("tan", 10F);
    }
    private static final HashMap<String, Float> MIX1996 = new HashMap<>();
    static {
        MIX1996.put("blue", 24F);
        MIX1996.put("green", 20F);
        MIX1996.put("orange", 16F);
        MIX1996.put("yellow", 14F);
        MIX1996.put("red", 13F);
        MIX1996.put("brown", 13F);
    }

    private static final HashMap<String, HashMap<String, Float>> hypothesisA = new HashMap<>();
    static {
        hypothesisA.put("bag1", MIX1994);
        hypothesisA.put("bag2", MIX1996);
    }

    private static final HashMap<String, HashMap<String, Float>> hypothesisB = new HashMap<>();
    static {
        hypothesisB.put("bag1", MIX1996);
        hypothesisB.put("bag2", MIX1994);
    }

    private static final HashMap<String, HashMap<String, HashMap<String, Float>>> hypotheses = new HashMap<>();
    static {
        hypotheses.put("A", hypothesisA);
        hypotheses.put("B", hypothesisB);
    }

    public MnM(List<String> hypotheses) {
        super(hypotheses);
    }

    /**
     *
     * @param data space spearated string, for example "bag1 yellow"
     * @param hypothesis "A" or "B"
     * @return probability of data under likelihood
     */
    @Override
    public float getLikelihood(String data, String hypothesis) {
        String [] parts = data.split(" ");
        // parts[0] = bag (e.g. "bag1" or "bag2"
        // parts[1] == color (e.g. "yellow" or "green"
        return hypotheses.get(hypothesis).get(parts[0].trim()).get(parts[1].trim());
    }

}
