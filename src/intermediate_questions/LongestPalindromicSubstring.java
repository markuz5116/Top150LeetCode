package intermediate_questions;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < s.length(); i++) {
            int currLeft = i;
            int currRight = i;
            while (currLeft >= 0 && currRight < s.length() && s.charAt(currLeft) == s.charAt(currRight)) {
                currLeft--;
                currRight++;
            }
            if (maxRight - maxLeft < currRight - currLeft) {
                maxLeft = currLeft;
                maxRight = currRight;
            }

            currLeft = i;
            currRight = i + 1;
            while (currLeft >= 0 && currRight < s.length() && s.charAt(currLeft) == s.charAt(currRight)) {
                currLeft--;
                currRight++;
            }
            if (maxRight - maxLeft < currRight - currLeft) {
                maxLeft = currLeft;
                maxRight = currRight;
            }
        }
        return s.substring(maxLeft + 1, maxRight);
    }
}
