package montecarlo;

public class DoublerBettor extends Bettor {

    private enum WagerResult {
        LOSS,
        WIN
    }

    public DoublerBettor(int wagerAttempts, float wagerAmount, float startingCapital) {
        super(wagerAttempts, wagerAmount, startingCapital);
    }

    @Override
    public float[] placeWagers() {
        float[] wagerProgression = new float[wagerAttempts];
        float remainingFunds = startingCapital;
        float previousWagerAmount = wagerAmount;
        WagerResult previousWagerResult = WagerResult.WIN;

        for (int i = 0; i < wagerAttempts; i++) {
            if (remainingFunds < wagerAmount) {
                for (int k = i; k < wagerAttempts; k++) {
                    wagerProgression[k] = remainingFunds;
                }
                break;
            }
            if (previousWagerResult == WagerResult.WIN) {
                if (Dice.rollDiceIsAWin()) {
                    remainingFunds += previousWagerAmount;
                } else {
                    previousWagerResult = WagerResult.LOSS;
                    remainingFunds -= previousWagerAmount;
                }
            } else if (previousWagerResult == WagerResult.LOSS) {
                previousWagerAmount *= 2;
                if (Dice.rollDiceIsAWin()) {
                    previousWagerResult = WagerResult.WIN;
                    remainingFunds += (previousWagerAmount * 2);
                } else {
                    remainingFunds -= (previousWagerAmount * 2);
                }
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
            DoublerBettor doublerBettor = new DoublerBettor(numAttempts, wagerAmount, startingCapital);
            float[] wagerProgression = doublerBettor.placeWagers();
            System.out.println(String.format("Initial = %8.2f, final = %8.2f", 10000.00, wagerProgression[numAttempts - 1]));
        }
    }
}
