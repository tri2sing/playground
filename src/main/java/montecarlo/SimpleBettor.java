package montecarlo;

public class SimpleBettor {
    private int wagerAttempts;
    private float wagerAmount;
    private float startingCapital;

    public SimpleBettor(int wagerAttempts, float wagerAmount, float startingCapital) {
        this.wagerAttempts = wagerAttempts;
        this.wagerAmount = wagerAmount;
        this.startingCapital = startingCapital;
    }

    public float [] placeWagers() {
        float [] wagerProgression = new float[wagerAttempts];
        float remainingFunds = startingCapital;
        for (int i = 0; i < wagerAttempts; i++) {
            if (Dice.rollDiceIsAWin()) {
                remainingFunds += wagerAmount;
            } else {
                remainingFunds -= wagerAmount;
            }
            wagerProgression[i] = remainingFunds;
        }
        return wagerProgression;
    }

    public static void main(String[] args) {
        int numBettors = 100;
        SimpleBettor[] simpleBettors = new SimpleBettor[numBettors];
        for (int i = 0; i < numBettors; i++) {
            // As the wager attempts increase the likelihood of bettor going broke increases
            simpleBettors[i] = new SimpleBettor(10000, 100, 10000);
        }
        for (SimpleBettor simpleBettor : simpleBettors) {
            float [] wagerResuls = simpleBettor.placeWagers();
            System.out.println(String.format("Initial = %8.2f, final = %8.2f", 10000.00, wagerResuls[9999]));
        }
    }
}
