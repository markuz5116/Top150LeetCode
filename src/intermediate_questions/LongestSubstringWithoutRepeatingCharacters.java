package intermediate_questions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int currLen = 0;
        Map<Character, Integer> uniqueCharToIdx = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (uniqueCharToIdx.containsKey(c)) {
                left = Math.max(uniqueCharToIdx.get(c) + 1, left);
            }
            uniqueCharToIdx.put(c, right);
            currLen = right - left + 1;
            maxLen = Integer.max(maxLen, currLen);
        }
        return maxLen;
    }
}
