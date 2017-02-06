package montecarlo;

public abstract class Bettor {
    protected Integer wagerAttempts;
    protected Float wagerAmount;
    protected Float startingCapital;

    public Bettor(Integer wagerAttempts, Float wagerAmount, Float startingCapital) {
        this.wagerAttempts = wagerAttempts;
        this.wagerAmount = wagerAmount;
        this.startingCapital = startingCapital;
    }

    public abstract Float [] placeWagers();
}
