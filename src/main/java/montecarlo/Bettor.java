package montecarlo;

public abstract class Bettor {
    protected Integer wagerAttempts;
    protected Float wagerAmount;
    protected Float startingCapital;
    protected Float wagerLossMultiplier;

    public Bettor(Integer wagerAttempts, Float wagerAmount, Float startingCapital, Float wagerLossMultiplier) {
        this.wagerAttempts = wagerAttempts;
        this.wagerAmount = wagerAmount;
        this.startingCapital = startingCapital;
        this.wagerLossMultiplier = wagerLossMultiplier;
    }

    public abstract Float [] placeWagers();
}
