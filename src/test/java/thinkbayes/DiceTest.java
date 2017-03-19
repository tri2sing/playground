package thinkbayes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DiceTest {
    @Test
    public void testOneRoll() throws Exception {
        List<Integer> sides = Arrays.asList(new Integer[] {4, 6, 8, 12, 20});
        Dice dices = new Dice(sides);
        assertThat(dices.getEvent(sides.get(0))).isEqualTo(1F/5F);
        dices.updateHypotheses(6);
        assertThat(dices.getEvent(4)).isEqualTo(0F);
        assertThat(dices.getEvent(6)).isEqualTo(0.392156863F);
        assertThat(dices.getEvent(8)).isEqualTo(0.294117647F);
        assertThat(dices.getEvent(12)).isEqualTo(0.19607843F);
        assertThat(dices.getEvent(20)).isEqualTo(0.11764707F);
    }

    @Test
    public void testMultippleRolls() throws Exception {
        List<Integer> sides = Arrays.asList(new Integer[] {4, 6, 8, 12, 20});
        Dice dices = new Dice(sides);
        assertThat(dices.getEvent(sides.get(0))).isEqualTo(1F/5F);
        Integer [] rolls = new Integer[] {6, 6, 8, 7, 7, 5, 4};
        for (Integer roll : rolls) {
            dices.updateHypotheses(roll);
        }
        assertThat(dices.getEvent(4)).isEqualTo(0F);
        assertThat(dices.getEvent(6)).isEqualTo(0F);
        assertThat(dices.getEvent(8)).isEqualTo(0.9432484537F);
        assertThat(dices.getEvent(12)).isEqualTo(0.055206135F);
        assertThat(dices.getEvent(20)).isEqualTo(0.0015454183F);
    }

}
