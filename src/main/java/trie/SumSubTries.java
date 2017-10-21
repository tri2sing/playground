package trie;

import java.util.HashMap;

public class SumSubTries {
    private class TrieNode {
        private int val;
        private HashMap<Character, TrieNode> children = new HashMap<>();
    }

    TrieNode root;

    public SumSubTries() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        char [] keys = key.toCharArray();
        TrieNode trav = root;
        for(int i = 0; i < keys.length; i++) {
            TrieNode child = trav.children.get(keys[i]);
            if(child == null) {
                child = new TrieNode();
                trav.children.put(keys[i], child);
            }
            if(i == keys.length - 1) child.val = val;
            trav = child;
        }
    }

    private int findSum(TrieNode root) {
        if(root == null) return 0;
        int sum = root.val;
        for (TrieNode node : root.children.values()) {
            sum += findSum(node);
        }
        return sum;
    }

    public int sum(String prefix) {
        char [] keys = prefix.toCharArray();
        TrieNode trav = root;
        for(int i = 0; i < keys.length; i++) {
            trav = trav.children.get(keys[i]);
            if(trav == null) return 0;
        }
        return findSum(trav);
    }
}
