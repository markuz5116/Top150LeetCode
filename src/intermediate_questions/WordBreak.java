package intermediate_questions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    class TrieNode {
        Map<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
        }

        int i = 0;
        while (i < s.length()) {
            int next = canFormS(root, root, s, i);
            if (next == i) {
                return false;
            }
            i = next;
        }
        return true;
    }

    private int canFormS(TrieNode root, TrieNode curr, String s, int i) {
        if (curr == null) {
            return i;
        }

        if (i >= s.length()) {
            return i;
        }

        char c = s.charAt(i);
        if (!curr.children.containsKey(c)) {
            return i;
        }

        curr = curr.children.get(c);
        return canFormS(root, curr, s, i + 1);
    }
}
