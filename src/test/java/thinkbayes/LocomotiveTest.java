package thinkbayes;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LocomotiveTest {

    @Test
    public void useUniformPrior() throws Exception {
        int [] numLocomotives = new int[] {500, 1000, 2000};
        float [] means = new float[] {152F, 164F, 171F};
        for (int i = 0; i < numLocomotives.length; i++) {
            List<Integer> hypotheses = IntStream.rangeClosed(1, numLocomotives[i]).boxed().collect(Collectors.toList());
            Locomotive locomotive = new Locomotive(hypotheses, Prior.UNIFORM);
            List<Float> observations = Arrays.asList(30F, 60F, 90F);
            for (Float observation : observations) {
                locomotive.updateHypotheses(observation);
            }
            // Rounding is necessary to tackle the floating point errors
            assertThat(means[i]).isEqualTo(Math.round(locomotive.mean()));
        }
    }

    @Test
    public void usePowerLawPrior() throws Exception {
        int [] numLocomotives = new int[] {500, 1000, 2000};
        float [] means = new float[] {131F, 133F, 134F};
        for (int i = 0; i < numLocomotives.length; i++) {
            List<Integer> hypotheses = IntStream.rangeClosed(1, numLocomotives[i]).boxed().collect(Collectors.toList());
            Locomotive locomotive = new Locomotive(hypotheses, Prior.POWER_LAW);
            List<Float> observations = Arrays.asList(30F, 60F, 90F);
            for (Float observation : observations) {
                locomotive.updateHypotheses(observation);
            }
            // Rounding is necessary to tackle the floating point errors
            assertThat(means[i]).isEqualTo(Math.round(locomotive.mean()));

            Integer fifthPercentile = locomotive.percentileEvent(5F);
            assertThat(fifthPercentile).isEqualTo(91);

            Integer ninetyfifthPercentile = locomotive.percentileEvent(95F);
            // floating point calculation errors, put the answer in a range.
            // The observed cases so far are 235, 242, and 243.
            assertThat(ninetyfifthPercentile).isBetween(235, 243);

        }
    }

}
