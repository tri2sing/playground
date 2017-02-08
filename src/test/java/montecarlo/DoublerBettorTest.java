package montecarlo;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class DoublerBettorTest {
    @Test
    public void IF_placeWagers_THEN_NonNullResult() throws Exception {
        DoublerBettor doublerBettor = new DoublerBettor(100, 100f, 1000f);
        Float [] wagerProgression = doublerBettor.placeWagers();
        assertThat(wagerProgression, is(notNullValue()));

    }

}
