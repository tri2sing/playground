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

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

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

    public Node find(Key key) {
        return find(root, key);
    }

    public Node findNextBigger(Key key) {
        return null;
    }

    public Node findPreviousSmaller(Key key) {
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
        int compare = key.compareTo(node.key);
        if (compare < 0) node.left = insert(node.left, key, value);
        else if (compare > 0) node.right = insert(node.right, key, value);
        else node.value = value;
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Node find(Node node, Key key) {
        if(node == null) return null;
        if(node.key == key) return node;
        if(key.compareTo(node.key) < 0) return find(node.left, key);
        else return find(node.right, key);
    }

    private void printTree(Node node) {
        if (node == null) return;
        printTree(node.left);
        System.out.println("Key = " + node.key + ", Value = " + node.value);
        printTree(node.right);
    }

}
