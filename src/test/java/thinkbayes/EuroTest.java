package thinkbayes;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class EuroTest {

    public static final int START_EVENT = 0;
    public static final int END_EVENT = 100;

    @Test
    public void useUniformPrior() throws Exception {
        List<Float> observations = new LinkedList<>();
        for(int i = 0; i < 140; i++)
            observations.add(Flip.HEADS);
        for(int i = 140; i < 250; i++)
            observations.add(Flip.TAILS);

        List<Integer> hypotheses = IntStream.rangeClosed(START_EVENT, END_EVENT).boxed().collect(Collectors.toList());
        Euro euro1 = new Euro(hypotheses);

        for (Float observation : observations) {
            euro1.updateHypotheses(observation);
        }
        assertThat(euro1.getMaximumLikelihoodEvent()).isEqualTo(56);
        assertThat(euro1.mean()).isEqualTo(55.962227F);
        assertThat(euro1.percentileEvent(5F)).isEqualTo(51);
        assertThat(euro1.percentileEvent(95F)).isEqualTo(61);

    }
}
