package trees;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer, String> bst;
    BinarySearchTree<Integer, String> bst1;

    @Before
    public void setUp() throws Exception {
        bst = new BinarySearchTree<>();
        bst.insert(4, "four");
        bst.insert(2, "two");
        bst.insert(3, "three");
        bst.insert(1, "one");
        bst.insert(6, "six");
        bst.insert(5, "five");
        bst.insert(8, "eight");
        bst1 = new BinarySearchTree<>();
        bst1.insert(4, "four");
        bst1.insert(2, "two");
        bst1.insert(3, "three");
        bst1.insert(1, "one");
        bst1.insert(8, "eight");
        bst1.insert(9, "nine");
        bst1.insert(5, "five");
    }

    @Test
    public void checkSize() {
        assertThat(bst.size()).isEqualTo(7);
    }

    @Test
    public void find_value_for_existing_key() {
        String value = bst.find(6);
        assertThat(value).isEqualTo("six");
    }

    @Test
    public void find_value_for_missing_key() {
        String value = bst.find(7);
        assertThat(value).isEqualTo(null);
    }

    @Test
    public void find_ceiling_for_existing_key() {
        Integer key = bst.findCeiling(7);
        assertThat(key.intValue()).isEqualTo(8);
        key = bst1.findCeiling(7);
        assertThat(key.intValue()).isEqualTo(8);
    }

}
