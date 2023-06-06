package easy_questions;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int longestPrefix = -1;
        while (longestPrefix < strs[0].length()) {
            longestPrefix++;
            char commonChar = 0;
            boolean hasMiss = false;
            for (String str : strs) {
                if (str.length() <= longestPrefix) {
                    hasMiss = true;
                    break;
                }

                if (commonChar == 0) {
                    commonChar = str.charAt(longestPrefix);
                    continue;
                }

                if (str.charAt(longestPrefix) != commonChar) {
                    hasMiss = true;
                    break;
                }
            }
            if (hasMiss) {
                break;
            }
        }

        if (longestPrefix == -1) {
            return "";
        }

        return strs[0].substring(0, longestPrefix);
    }
}
