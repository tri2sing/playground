package montecarlo;

import java.util.Map;
import java.util.TreeMap;

public class BettorAnalyzer {

    public Map<Float, Float> analyzeMultiplierBettors(
            Integer numBettors,
            Integer wagerAttempts,
            Float wagerAmount,
            Float startingCapital,
            Float lowerWagerLossMultiplier,
            Float higherWagerLossMultiplier,
            Float wagerLossMultiplierIncrement) {
        TreeMap<Float, Float> results = new TreeMap<>();
        for (Float f = lowerWagerLossMultiplier; f <= higherWagerLossMultiplier + wagerLossMultiplierIncrement; f += wagerLossMultiplierIncrement) {
            Float numBusted = 0f;
            for (int i = 0; i < numBettors; i++) {
                MultiplierBettor multiplierBettor = new MultiplierBettor(wagerAttempts, wagerAmount, startingCapital, f);
                Float[] wagerProgression = multiplierBettor.placeWagers();
                if (wagerProgression[wagerAttempts - 1] < startingCapital) {
                    numBusted++;
                }
                results.put(f, numBusted / numBettors);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        BettorAnalyzer bettorAnalyzer = new BettorAnalyzer();
        Map<Float, Float> analysis = bettorAnalyzer.analyzeMultiplierBettors(
                10000,
                1000,
                100f,
                10000f,
                0.1f,
                4.0f,
                0.1f);
        for (Map.Entry<Float, Float> entry : analysis.entrySet()) {
            System.out.println(String.format("Multiplier %4.2f, Busted%% %4.2f", entry.getKey(), entry.getValue()*100f));
        }
    }

}
