package montecarlo;

/**
 * Class that represents a bettor who bets the same amount in every wager.
 */
public class SimpleBettor extends Bettor {

    public SimpleBettor(Integer wagerAttempts, Float wagerAmount, Float startingCapital, Float wagerLossMultiplier) {
        super(wagerAttempts, wagerAmount, startingCapital, wagerLossMultiplier);
    }

    @Override
    public Float[] placeWagers() {
        Float[] wagerProgression = new Float[wagerAttempts];
        Float remainingFunds = startingCapital;
        for (Integer i = 0; i < wagerAttempts; i++) {
            // Our remaining funds are less than what we are supposed to wager, so we will quit
            if (remainingFunds < wagerAmount) {
                for (Integer k = i; k < wagerAttempts; k++) {
                    wagerProgression[k] = remainingFunds;
                }
                break;
            }
            if (Dice.rollDiceIsAWin()) {
                remainingFunds += (wagerLossMultiplier * wagerAmount);
            } else {
                remainingFunds -= (wagerLossMultiplier * wagerAmount);
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
        Float wagerLossMultiplier = 1f;

        for (Integer i = 0; i < numBettors; i++) {
            SimpleBettor simpleBettor = new SimpleBettor(numAttempts, wagerAmount, startingCapital, wagerLossMultiplier);
            Float[] wagerProgression = simpleBettor.placeWagers();
            System.out.println(String.format("Initial = %8.2f, final = %8.2f", 10000.00, wagerProgression[numAttempts - 1]));
        }
    }
}
