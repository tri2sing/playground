package montecarlo;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplierBettorTest {
    @Test
    public void IF_placeWagers_THEN_NonNullResult() throws Exception {
        MultiplierBettor multiplierBettor = new MultiplierBettor(100, 100f, 1000f, 2.0f);
        Float [] wagerProgression = multiplierBettor.placeWagers();
        assertThat(wagerProgression, is(notNullValue()));

    }

}
