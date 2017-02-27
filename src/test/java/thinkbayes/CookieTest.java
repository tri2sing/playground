package thinkbayes;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CookieTest {

    @Test
    public void setUpHypothesis() throws Exception {
        List<String> hypothesis = Arrays.asList(new String[] {"bowl 1", "bowl 2", "Bowl 3"});
        Cookie cookiePmf = new Cookie(hypothesis);
        assertThat(cookiePmf.get("bowl 1"), is(1F/3F));
    }

}
