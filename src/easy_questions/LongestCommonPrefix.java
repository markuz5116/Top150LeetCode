package easy_questions;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
    public class TrieNode {
        Map<Character, TrieNode> children;
        int count;

        public TrieNode() {
            this.children = new HashMap<>();
            this.count = 0;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();
        int n = strs.length;
        root.count = n;

        for (String str : strs) {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                if (!curr.children.containsKey(str.charAt(i))) {
                    curr.children.put(str.charAt(i), new TrieNode());
                }
                curr = curr.children.get(str.charAt(i));
                curr.count++;
            }
        }

        String longestPrefix = "";
        while (root.count == n && !root.children.isEmpty()) {
            for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
                Character c = entry.getKey();
                root = entry.getValue();
                if (root.count == n) {
                    longestPrefix += c;
                }
            }
        }
        return longestPrefix;
    }
}
