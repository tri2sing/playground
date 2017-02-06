package montecarlo;

public class SimpleBettor extends Bettor {

    public SimpleBettor(Integer wagerAttempts, Float wagerAmount, Float startingCapital) {
        super(wagerAttempts, wagerAmount, startingCapital);
    }

    @Override
    public Float[] placeWagers() {
        Float[] wagerProgression = new Float[wagerAttempts];
        Float remainingFunds = startingCapital;
        for (Integer i = 0; i < wagerAttempts; i++) {
            if (remainingFunds < wagerAmount) {
                for (Integer k = i; k < wagerAttempts; k++) {
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
        Integer numBettors = 100;
        Integer numAttempts = 2500;
        Float wagerAmount = 100f;
        Float startingCapital = 10000f;

        for (Integer i = 0; i < numBettors; i++) {
            SimpleBettor simpleBettor = new SimpleBettor(numAttempts, wagerAmount, startingCapital);
            Float[] wagerProgression = simpleBettor.placeWagers();
            System.out.println(String.format("Initial = %8.2f, final = %8.2f", 10000.00, wagerProgression[numAttempts - 1]));
        }
    }
}
