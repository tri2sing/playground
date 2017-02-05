package montecarlo;

public abstract class Bettor {
    protected int wagerAttempts;
    protected float wagerAmount;
    protected float startingCapital;

    public Bettor(int wagerAttempts, float wagerAmount, float startingCapital) {
        this.wagerAttempts = wagerAttempts;
        this.wagerAmount = wagerAmount;
        this.startingCapital = startingCapital;
    }

    public abstract float [] placeWagers();
}
