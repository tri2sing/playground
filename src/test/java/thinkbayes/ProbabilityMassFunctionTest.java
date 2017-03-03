package thinkbayes;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ProbabilityMassFunctionTest {


    @Test
    public void testSetAndGet() throws Exception {
        ProbabilityMassFunction pMF = new ProbabilityMassFunction();
        pMF.setEvent("Event 1", 0.5f);
        assertThat(pMF.getEvent("Event 1"), is(0.5f));
    }

    @Test
    public void normalize() throws Exception {
        ProbabilityMassFunction pMF = new ProbabilityMassFunction();
        for(int i = 1; i < 6; i++) {
            pMF.setEvent("event" + String.valueOf(i), (float) i);
        }
        pMF.normalize();
        for (int i = 1; i < 6; i++) {
            float probability = pMF.getEvent("event" + String.valueOf(i));
            assertThat(probability, is((float)i/15f)); // 15 = 1 + ... + 5
        }
    }

}
