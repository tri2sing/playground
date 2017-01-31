package montecarlo;

public class Bettor {
    private int wagerAttempts;
    private float wagerAmount;
    private float availableFunds;

    public Bettor(int wagerAttempts, float wagerAmount, float availableFunds) {
        this.wagerAttempts = wagerAttempts;
        this.wagerAmount = wagerAmount;
        this.availableFunds = availableFunds;
    }

    public float placeWagers() {
        float resultingFunds = availableFunds;
        for (int i = 0; i < wagerAttempts; i++) {
            if (resultingFunds < 0) {
                return 0;
            }
            if (Dice.rollDiceIsAWin()) {
                resultingFunds += wagerAmount;
            } else {
                resultingFunds -= wagerAmount;
            }
        }
        return resultingFunds;
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
