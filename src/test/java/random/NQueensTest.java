package random;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class NQueensTest {
    @Test
    public void test1() {
        List<String> sol1 = Arrays.asList(new String [] {"..Q.", "Q...", "...Q", ".Q.."});
        List<String> sol2 = Arrays.asList(new String [] {".Q..",  "...Q", "Q...", "..Q."});
        List<List<String>> result = new LinkedList<>();
        result.add(sol1);
        result.add(sol2);

        NQueens nq = new NQueens();
        assertThat(nq.solveNQueens(4)).isEqualTo(result);
    }

}
