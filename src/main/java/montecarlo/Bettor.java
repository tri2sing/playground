package montecarlo;

public class Bettor {
    private int wagerAttempts;
    private float wagerAmount;
    private float startingCapital;
    private float [] wagerProgression;

    public Bettor(int wagerAttempts, float wagerAmount, float startingCapital) {
        this.wagerAttempts = wagerAttempts;
        this.wagerAmount = wagerAmount;
        this.startingCapital = startingCapital;
        this.wagerProgression = null;
    }

    public float placeWagers() {
        wagerProgression = new float[wagerAttempts];
        float remainingFunds = startingCapital;
        for (int i = 0; i < wagerAttempts; i++) {
            if (Dice.rollDiceIsAWin()) {
                remainingFunds += wagerAmount;
            } else {
                remainingFunds -= wagerAmount;
            }
            wagerProgression[i] = remainingFunds;
        }
        return remainingFunds;
    }

    public float [] getWagerProgression() {
        return wagerProgression;
    }

    public static void main(String[] args) {
        int numBettors = 100;
        Bettor [] bettors = new Bettor[numBettors];
        for (int i = 0; i < numBettors; i++) {
            // As the wager attempts increase the likelihood of bettor going broke increases
            bettors[i] = new Bettor(10000, 100, 10000);
        }
        for (Bettor bettor : bettors) {
            float resultingFunds = bettor.placeWagers();
            System.out.println(String.format("Initial = %8.2f, final = %8.2f", 10000.00, resultingFunds));
        }
    }
}
