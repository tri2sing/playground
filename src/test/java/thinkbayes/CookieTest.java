package thinkbayes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class CookieTest {

    @Test
    public void setUpPriorForBowls() throws Exception {
        List<String> bowls = Arrays.asList(new String[] {"bowl 1", "bowl 2", "Bowl 3"});
        Cookie cookiePmf = new Cookie(bowls);
        assertThat(cookiePmf.get("bowl 1")).isEqualTo(1F/3F);
    }

    @Test
    public void setAndGetMixesForBowls() throws Exception {
        List<String> bowls = Arrays.asList(new String[] {"bowl 1", "bowl 2"});
        Cookie cookiePmf = new Cookie(bowls);

        HashMap<String, Float> mix1 = new HashMap<>();
        mix1.put("vanilla", 0.75F);
        mix1.put("chocolate", 0.25F);
        cookiePmf.setBowlMix("bowl 1", mix1);

        HashMap<String, Float> mix2 = new HashMap<>();
        mix2.put("vanilla", 0.5F);
        mix2.put("chocolate", 0.5F);
        cookiePmf.setBowlMix("bowl 2", mix2);

        assertThat(cookiePmf.getLikelihood("bowl 1", "vanilla"))
                .isEqualTo(0.75F);
        assertThat(cookiePmf.getLikelihood("bowl 2", "vanilla"))
                .isEqualTo(0.5F);

    }

}
