package montecarlo;

import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

public class DiceTest {

    @Test
    public void testRollDiceValidInput() throws Exception {
        int roll = Dice.rollDiceValue(1, 100);
        assertTrue(1 <= roll && roll <= 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDiceRollInvalidInput() {
        int roll = Dice.rollDiceValue(100, 1);
    }
}
