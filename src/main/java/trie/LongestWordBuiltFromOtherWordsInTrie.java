package trie;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LongestWordBuiltFromOtherWordsInTrie {
    // We are looking for longest word that can be built character by character from
    // other words in the trie, and not for the absolute longest word in the trie.

    private TrieNode root = new TrieNode();
    private Set<String> lookup = new HashSet<>();

    public String longestWord(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i].toCharArray());
            lookup.add(words[i]);
        }
        lookup.add("");
        return dfsMaxDepth(root, "");
    }

    private void insert(char[] word) {
        TrieNode trav = root;
        for (int i = 0; i < word.length; i++) {
            TrieNode child = trav.children.get(word[i]);
            if (child == null) {
                child = new TrieNode();
                trav.children.put(word[i], child);
            }
            trav = child;
        }
    }

    private String dfsMaxDepth(TrieNode node, String prefix) {
        if(!lookup.contains(prefix)) return "";
        if (node.children.size() == 0) return prefix;
        String maxChildResult = prefix;
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            String childResult = dfsMaxDepth(entry.getValue(), prefix + entry.getKey());
            if (childResult.length() > maxChildResult.length())
                maxChildResult = childResult;
        }
        return maxChildResult;
    }

    private class TrieNode {
        private Map<Character, TrieNode> children = new TreeMap<>();
    }
}
