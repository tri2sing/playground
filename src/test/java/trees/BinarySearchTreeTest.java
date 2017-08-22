package trees;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer, String> bst;

    @Before
    public void setUp() throws Exception {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void printTree() {
        bst.insert(2, "two");
        bst.insert(3, "three");
        bst.insert(1, "one");
        assertThat(bst.size()).isEqualTo(3);
    }

}
