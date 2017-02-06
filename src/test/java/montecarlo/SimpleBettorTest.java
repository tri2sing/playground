package montecarlo;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleBettorTest {

    @Test
    public void IF_placeWagers_RETURNS_NonNull() throws Exception {
        SimpleBettor simpleBettor = new SimpleBettor(100, 100f, 1000f);
        simpleBettor.placeWagers();
        Float[] wagerProgression = simpleBettor.placeWagers();
        assertThat(wagerProgression, is(notNullValue()));
    }

}
