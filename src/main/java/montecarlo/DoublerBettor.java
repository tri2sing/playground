package montecarlo;

public class DoublerBettor extends Bettor {

    private enum WagerResult {
        LOSS,
        WIN
    }

    public DoublerBettor(Integer wagerAttempts, Float wagerAmount, Float startingCapital) {
        super(wagerAttempts, wagerAmount, startingCapital);
    }

    @Override
    public Float[] placeWagers() {
        Float[] wagerProgression = new Float[wagerAttempts];
        Float remainingFunds = startingCapital;
        Float previousWagerAmount = wagerAmount;
        WagerResult previousWagerResult = WagerResult.WIN;

        for (Integer i = 0; i < wagerAttempts; i++) {
            if (remainingFunds < wagerAmount) {
                for (Integer k = i; k < wagerAttempts; k++) {
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
        Integer numBettors = 100;
        Integer numAttempts = 2500;
        Float wagerAmount = 100f;
        Float startingCapital = 10000f;

        for (Integer i = 0; i < numBettors; i++) {
            DoublerBettor doublerBettor = new DoublerBettor(numAttempts, wagerAmount, startingCapital);
            Float[] wagerProgression = doublerBettor.placeWagers();
            System.out.println(String.format("Initial = %8.2f, final = %8.2f", 10000.00, wagerProgression[numAttempts - 1]));
        }
    }
}
