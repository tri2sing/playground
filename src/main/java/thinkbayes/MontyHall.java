package thinkbayes;

import java.util.List;

/**
 * Implementation of Monty Hall problem for a specific scenario.
 * Guest chooses door 1, and Monty opens door 2 to reveal a goat.
 */
public class MontyHall extends ProbabilityMassFunction {
    private String doorUserChooses;
    private String doorMontyOpens;

    public MontyHall(List<String> doors) {
        super();
        doors.stream().forEach(door -> set(door, 1F));
        normalize();
    }

    public void userChoosesDoor(String door) {
        doorUserChooses = door;
    }

    public void montyOpensDoor(String door) {
        doorMontyOpens = door;
    }
    /**
     * @param doorMontyOpens the door to be opened by Monty
     * @param hypothesisThatCarIsBehind the door that has the car
     * @return P(doorMontyOpens | hypothesisThatCarIsBehind)
     */
    public float likelihood(String doorMontyOpens, String hypothesisThatCarIsBehind) {
        if(doorMontyOpens.equals(hypothesisThatCarIsBehind))
            return 0F;
        else if (doorUserChooses.equals(hypothesisThatCarIsBehind))
            return .5F;
        else
            return 1F;
    }

    public void update(String doorMontyOpens) {
        pmf.forEach((k, v) -> {mult(k, likelihood(doorMontyOpens, k));});
        normalize();
    }
}
