package montecarlo;

public class SimpleBettor extends Bettor {

    public SimpleBettor(int wagerAttempts, float wagerAmount, float startingCapital) {
        super(wagerAttempts, wagerAmount, startingCapital);
    }

    @Override
    public float[] placeWagers() {
        float[] wagerProgression = new float[wagerAttempts];
        float remainingFunds = startingCapital;
        for (int i = 0; i < wagerAttempts; i++) {
            if (remainingFunds < wagerAmount) {
                for (int k = i; k < wagerAttempts; k++) {
                    wagerProgression[k] = remainingFunds;
                }
                break;
            }
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
        int numAttempts = 2500;
        float wagerAmount = 100;
        float startingCapital = 10000;

        for (int i = 0; i < numBettors; i++) {
            SimpleBettor simpleBettor = new SimpleBettor(numAttempts, wagerAmount, startingCapital);
            float[] wagerProgression = simpleBettor.placeWagers();
            System.out.println(String.format("Initial = %8.2f, final = %8.2f", 10000.00, wagerProgression[numAttempts - 1]));
        }
    }
}
