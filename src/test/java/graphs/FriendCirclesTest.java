package graphs;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FriendCirclesTest {
    @Test
    public void test1() {
        int [][] friends = new int[][] {{1,1,0}, {1,1,0}, {0,0,1}};
        // friends[i][j] == 1 => i and j are friends
        FriendCircles fc = new FriendCircles();
        assertThat(fc.findCircleNum(friends)).isEqualTo(2);
    }

    @Test
    public void test2() {
        int [][] friends = new int[][] {{1,1,0}, {1,1,1}, {0,1,1}};
        // friends[i][j] == 1 => i and j are friends
        FriendCircles fc = new FriendCircles();
        assertThat(fc.findCircleNum(friends)).isEqualTo(1);
    }

}
