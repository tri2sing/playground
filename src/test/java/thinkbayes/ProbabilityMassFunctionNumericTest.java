package thinkbayes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProbabilityMassFunctionNumericTest {
    @Test
    public void testSetAndHasEvent() throws Exception {
        ProbabilityMassFunctionNumeric<Integer, Float> pmf =
                new ProbabilityMassFunctionNumeric<Integer, Float>();
        pmf.setEvent(1, 0.5F);
        assertThat(pmf.hasEvent(1)).isEqualTo(true);
    }

    @Test
    public void testSetAndGetEvent() throws Exception {
        ProbabilityMassFunctionNumeric<Integer, Float> pmf =
                new ProbabilityMassFunctionNumeric<Integer, Float>();
        pmf.setEvent(1, 0.5F);
        assertThat(pmf.getEvent(1)).isEqualTo(0.5F);
    }

    @Test
    public void testNormalize() throws Exception {
        ProbabilityMassFunctionNumeric<Integer, Float> pmf =
                new ProbabilityMassFunctionNumeric<Integer, Float>();
        for (int i = 1; i < 6; i++) {
            pmf.setEvent(i, (float) i);
        }
        pmf.normalize();
        for (int i = 1; i < 6; i++) {
            float value = pmf.getEvent(i);
            assertThat(value).isEqualTo((float) i / 15F); // 15 = 1 + 2 + ... + 5
        }
    }

    @Test
    public void increment() throws Exception {
        ProbabilityMassFunctionNumeric<Integer, Float> pmf =
                new ProbabilityMassFunctionNumeric<Integer, Float>();
        pmf.setEvent(1, 0.5F);
        pmf.increment(1, 0.25F);
        assertThat(pmf.getEvent(1)).isEqualTo(0.75F);
    }

    @Test
    public void multiply() throws Exception {
        ProbabilityMassFunctionNumeric<Integer, Float> pmf =
                new ProbabilityMassFunctionNumeric<Integer, Float>();
        pmf.setEvent(1, 0.5F);
        pmf.multiply(1, 0.25F);
        assertThat(pmf.getEvent(1)).isEqualTo(0.125F);
    }

    @Test
    public void mean() throws Exception {
        ProbabilityMassFunctionNumeric<Integer, Float> pmf =
                new ProbabilityMassFunctionNumeric<Integer, Float>();
        for (int i = 1; i < 6; i++) {
            pmf.setEvent(i, (float) i);
        }
        pmf.normalize();
        assertThat(pmf.mean()).isEqualTo(55F/15F);
    }

    @Test
    public void percentileEvent() throws Exception {
        ProbabilityMassFunctionNumeric<Integer, Float> pmf =
                new ProbabilityMassFunctionNumeric<Integer, Float>();
        for (int i = 1; i < 6; i++) {
            pmf.setEvent(i, (float) i);
        }
        pmf.normalize();
        assertThat(pmf.percentileEvent(25F)).isEqualTo(3);
    }

    @Test
    public void getMaximumLikelihoodEvent() throws Exception {
        ProbabilityMassFunctionNumeric<Integer, Float> pmf =
                new ProbabilityMassFunctionNumeric<Integer, Float>();
        for (int i = 1; i < 6; i++) {
            pmf.setEvent(i, (float) i);
        }
        pmf.normalize();
        assertThat(pmf.getMaximumLikelihoodEvent()).isEqualTo(5);
    }

    @Test
    public void getMaximumLikelihoodValue() throws Exception {
        ProbabilityMassFunctionNumeric<Integer, Float> pmf =
                new ProbabilityMassFunctionNumeric<Integer, Float>();
        for (int i = 1; i < 6; i++) {
            pmf.setEvent(i, (float) i);
        }
        pmf.normalize();
        assertThat(pmf.getMaximumLikelihoodValue()).isEqualTo(5F/15F);
    }

    @Test
    public void add() throws Exception {
        ProbabilityMassFunctionNumeric<Integer, Float> pmf1 =
                new ProbabilityMassFunctionNumeric<Integer, Float>();
        for (int i = 1; i < 7; i++) {
            pmf1.setEvent(i, 1F);
        }
        pmf1.normalize();

        ProbabilityMassFunctionNumeric<Integer, Float> pmf2 =
                new ProbabilityMassFunctionNumeric<Integer, Float>();
        for (int i = 1; i < 7; i++) {
            pmf2.setEvent(i, 1F);
        }
        pmf2.normalize();

        ProbabilityMassFunctionNumeric<Integer, Float> pmf3 =
                pmf1.add(pmf2);
        assertThat(pmf3.getEvent(2)).isEqualTo(0.02777778f);
        assertThat(pmf3.getEvent(7)).isEqualTo(0.16666667f);
    }

}
