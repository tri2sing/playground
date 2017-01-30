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
            if (Dice.rollDiceIsAWin()) {
                resultingFunds += wagerAmount;
            } else {
                resultingFunds -= wagerAmount;
            }
        }
        return resultingFunds;
    }

    public static void main(String[] args) {
        Bettor bettor = new Bettor(100, 100, 10000);
        float resultingFunds = bettor.placeWagers();
        System.out.println(String.format("Initial amount = %.2f, final amount = %.2f", 10000.00, resultingFunds));
    }
}
