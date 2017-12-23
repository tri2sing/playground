package maths;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BeautifulArrangementTest {
    @Test
    public void test1() {
        BeautifulArrangement ba = new BeautifulArrangement();
        assertThat(ba.countArrangement(2)).isEqualTo(2);
    }
}
