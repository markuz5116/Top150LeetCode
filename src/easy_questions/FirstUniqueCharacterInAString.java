package easy_questions;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charToIdx = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charToIdx.containsKey(c)) {
                charToIdx.put(c, -1);
                continue;
            }
            charToIdx.put(c, i);
        }

        int firstUniqueIdx = -1;
        for (Map.Entry<Character, Integer> entry : charToIdx.entrySet()) {
            int idx = entry.getValue();
            if (idx != -1) {
                if (firstUniqueIdx == -1) {
                    firstUniqueIdx = idx;
                    continue;
                }
                firstUniqueIdx = Integer.min(idx, firstUniqueIdx);
            }
        }
        return firstUniqueIdx;
    }
}
