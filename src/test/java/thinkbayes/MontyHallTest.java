package thinkbayes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MontyHallTest {

    @Test
    public void testMontyHall() throws Exception {
        List<String> doors = Arrays.asList(new String [] {"1", "2", "3"});
        MontyHall mh = new MontyHall(doors);
        assertThat(mh.getEvent("1")).isEqualTo(1F/3F);
        assertThat(mh.getEvent("3")).isEqualTo(1F/3F);
        mh.userChoosesDoor("1");
        mh.montyOpensDoor("2");
        mh.update("2");
        assertThat(mh.getEvent("1")).isEqualTo(1F/3F);
        assertThat(mh.getEvent("2")).isEqualTo(0F);
        assertThat(mh.getEvent("3")).isEqualTo(2F/3F);
    }
}
