package montecarlo;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class BettorTest {

    @Test
    public void IF_noPlaceWagers_THEN_getWagerProgressions_RETURNS_Null() throws Exception {
        Bettor bettor = new Bettor(100, 100, 10000);
        float[] wagerProgression = bettor.getWagerProgression();
        assertThat(wagerProgression, is(nullValue()));
    }

    @Test
    public void IF_placeWagers_THEN_getWagerProgressions_RETURNS_NonNull() throws Exception {
        Bettor bettor = new Bettor(100, 100, 10000);
        bettor.placeWagers();
        float[] wagerProgression = bettor.getWagerProgression();
        assertThat(wagerProgression, is(notNullValue()));
    }

}
