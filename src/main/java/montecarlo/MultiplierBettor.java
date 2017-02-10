package montecarlo;

/**
 * Class that represents a bettor who doubles the bet on every loss.
 * This apprach also goes by the name of Martingale stragegy in betting.
 */
public class MultiplierBettor extends Bettor {

    private enum WagerResult {
        LOSS,
        WIN
    }

    public MultiplierBettor(Integer wagerAttempts, Float wagerAmount, Float startingCapital, Float wagerLossMultiplier) {
        super(wagerAttempts, wagerAmount, startingCapital, wagerLossMultiplier);
    }

    @Override
    public Float[] placeWagers() {
        Float[] wagerProgression = new Float[wagerAttempts];
        Float remainingFunds = startingCapital;
        Float previousWagerAmount = wagerAmount;
        WagerResult previousWagerResult = WagerResult.WIN;

        for (Integer i = 0; i < wagerAttempts; i++) {
            if (previousWagerResult == WagerResult.WIN) {
                if (remainingFunds < previousWagerAmount) {
                    previousWagerAmount = remainingFunds;
                }
                if (Dice.rollDiceIsAWin()) {
                    remainingFunds += previousWagerAmount;
                } else {
                    previousWagerResult = WagerResult.LOSS;
                    remainingFunds -= previousWagerAmount;
                }
            } else if (previousWagerResult == WagerResult.LOSS) {
                if (remainingFunds < (wagerLossMultiplier * previousWagerAmount)) {
                    previousWagerAmount = remainingFunds;
                } else {
                    previousWagerAmount *= wagerLossMultiplier;
                }
                if (Dice.rollDiceIsAWin()) {
                    previousWagerResult = WagerResult.WIN;
                    remainingFunds += previousWagerAmount;
                    previousWagerAmount = wagerAmount;
                } else {
                    remainingFunds -= previousWagerAmount;
                }
            }
            if (remainingFunds == 0) {
                for (Integer k = i; k < wagerAttempts; k++) {
                    wagerProgression[k] = remainingFunds;
                }
                break;
            }
            wagerProgression[i] = remainingFunds;
        }
        return wagerProgression;
    }

    public static void main(String[] args) {
        Integer numBettors = 100;
        Integer numAttempts = 5000;
        Float wagerAmount = 100f;
        Float startingCapital = 10000f;
        Float wagerLossMultiplier = 2f;

        for (Integer i = 0; i < numBettors; i++) {
            MultiplierBettor multiplierBettor = new MultiplierBettor(numAttempts, wagerAmount, startingCapital, wagerLossMultiplier);
            Float[] wagerProgression = multiplierBettor.placeWagers();
            System.out.println(String.format("Initial = %8.2f, final = %8.2f", 10000.00, wagerProgression[numAttempts - 1]));
        }
    }
}
