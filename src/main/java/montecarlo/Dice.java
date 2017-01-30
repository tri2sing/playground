package montecarlo;

import java.util.Random;

public class Dice {
    private static final Random random = new Random();

    /**
     * Generates a value for the roll of a dice.
     * @param min inclusive minimum value for dice roll
     * @param max inclusive maximum value for dice rool
     */
    public static int rollDiceValue(int min, int max) throws IllegalArgumentException {
        if (min >= max) {
            throw new IllegalArgumentException(String.format("max = %d should be greater than min = %d", max, min));
        }
        return random.nextInt(max - min + 1);
    }

    /**
     * Generates an outcome with a 49% probability of bettor winning.
     * @return true if the roll resulted in a win, or false if otherwise.
     */
    public static boolean rollDiceIsAWin() {
        boolean outcome = false;
        int value = rollDiceValue(1, 100);
        if (50 < value && value < 100) {
            outcome = true;
        }
        return outcome;
    }
}
