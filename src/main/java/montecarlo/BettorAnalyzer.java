package montecarlo;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BettorAnalyzer {
    private static AtomicInteger numBustedBettors;

    public Map<Float, Float> analyzeMultiplierBettors(
            Integer numBettors,
            Integer wagerAttempts,
            Float wagerAmount,
            Float startingCapital,
            Float lowerWagerLossMultiplier,
            Float higherWagerLossMultiplier,
            Float wagerLossMultiplierIncrement) {
        TreeMap<Float, Float> results = new TreeMap<>();
        for (Float f = lowerWagerLossMultiplier; f < higherWagerLossMultiplier + wagerLossMultiplierIncrement; f += wagerLossMultiplierIncrement) {
            numBustedBettors = new AtomicInteger(0);
            Thread[] bettorThreads = new Thread[numBettors];
            for (int i = 0; i < numBettors; i++) {
                bettorThreads[i] = new Thread(new BettorRunnable(wagerAttempts, wagerAmount, startingCapital, f));
                bettorThreads[i].start();
            }
            for (int i = 0; i < numBettors; i++) {
                try {
                    bettorThreads[i].join();
                } catch (InterruptedException e) {
                    System.out.println("Thread " + String.valueOf(i) + ": " + e.getMessage());
                }
            }
            results.put(f, (float) numBustedBettors.get() / (float) numBettors);
        }
        return results;
    }


    private static class BettorRunnable implements Runnable {
        private Integer wagerAttempts;
        private Float wagerAmount;
        private Float startingCapital;
        private Float wagerLossMultiplier;

        public BettorRunnable(Integer wagerAttempts, Float wagerAmount, Float startingCapital, Float wagerLossMultiplier) {
            this.wagerAttempts = wagerAttempts;
            this.wagerAmount = wagerAmount;
            this.startingCapital = startingCapital;
            this.wagerLossMultiplier = wagerLossMultiplier;
        }

        @Override
        public void run() {
            MultiplierBettor multiplierBettor = new MultiplierBettor(wagerAttempts, wagerAmount, startingCapital, wagerLossMultiplier);
            Float[] wagerProgression = multiplierBettor.placeWagers();
            if (wagerProgression[wagerAttempts - 1] < startingCapital) {
                int numBusted = BettorAnalyzer.numBustedBettors.incrementAndGet();
            }
        }
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
            System.out.println(String.format("Multiplier %4.2f, Busted%% %4.2f", entry.getKey(), entry.getValue() * 100f));
        }
    }

}
