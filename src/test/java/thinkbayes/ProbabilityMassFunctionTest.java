package thinkbayes;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ProbabilityMassFunctionTest {


    @Test
    public void testSetAndGet() throws Exception {
        ProbabilityMassFunction pMF = new ProbabilityMassFunction();
        pMF.set("Event 1", 0.5f);
        assertThat(pMF.get("Event 1"), is(0.5f));
    }

    @Test
    public void normalize() throws Exception {
        ProbabilityMassFunction pMF = new ProbabilityMassFunction();
        for(int i = 1; i < 6; i++) {
            pMF.set("event" + String.valueOf(i), (float) i);
        }
        pMF.normalize();
        for (int i = 1; i < 6; i++) {
            float probability = pMF.get("event" + String.valueOf(i));
            assertThat(probability, is((float)i/15f)); // 15 = 1 + ... + 5
        }
    }

}
