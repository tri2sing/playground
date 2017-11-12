package trees;

// Find closest node
// Find number of nodes at a level
// Print each level in a separate line
// Find nodes within a range of keys
// Statistics trees
// Find kth element in tree
// Find rand of element x
// Find median
// Find common ancestor

import java.util.function.Supplier;

public class BinarySearchTree<Key extends Number, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int size; // number of nodes in subtree

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.size = size;
        }
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public int size() {
        return size(root);
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    public Value find(Key key) {
        Node result = find(root, key);
        if (result == null) return null;
        else return result.value;
    }

    public Key findCeiling(Key key) {
        Node result = findCeiling(root, key);
        if (result == null) return null;
        else return result.key;
    }

    public Key findFloor(Key key) {
        return null;
    }

    public void printTree() {
        printTree(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.size;
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int compare = key.intValue() - node.key.intValue();
        if (compare < 0) node.left = insert(node.left, key, value);
        else if (compare > 0) node.right = insert(node.right, key, value);
        else node.value = value;
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Node find(Node node, Key key) {
        if (node == null) return null;
        if (node.key == key) return node;
        if (key.intValue() - node.key.intValue() < 0) return find(node.left, key);
        else return find(node.right, key);
    }

    private Node findCeiling(Node node, Key key) {
        if (node == null)  {
            return null;
        }
        int currentdiff = node.key.intValue() - key.intValue();
        if (currentdiff <= 0) {
            return findCeiling(node.right, key);
        }
        Node left = findCeiling(node.left, key);
        if (left == null) return node;
        return left.key.intValue() < node.key.intValue()? left : node;
    }

    private void printTree(Node node) {
        if (node == null) return;
        printTree(node.left);
        System.out.println("Key = " + node.key + ", Value = " + node.value);
        printTree(node.right);
    }

}
