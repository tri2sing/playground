package random;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

public class AutoBoxTest {
    private AutoBox instance;

    @Before
    public void setUp() {
        instance = new AutoBox();
    }

    @Test
    public void letterCombinations() throws Exception {
        List<String> result = instance.letterCombinations("23");
        String [] strArray = new String[] {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        List<String> expected = new LinkedList<>();
        for(int i = 0; i < strArray.length; i++){
            expected.add(strArray[i]);
        }
        assertThat(result).isEqualTo(expected);
    }

}
