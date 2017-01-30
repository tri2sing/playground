package montecarlo;

import java.util.Random;

public class Dice {
    private static final Random random = new Random();

    /**
     * Generates a value for the roll of a dice.
     * @param min inclusive minimum value for dice roll
     * @param max inclusive maximum value for dice rool
     */
    public static int rollDice(int min, int max) throws IllegalArgumentException {
        if (min >= max) {
            throw new IllegalArgumentException(String.format("max = %d should be greater than min = %d", max, min));
        }
        return random.nextInt(max - min + 1);
    }
}
