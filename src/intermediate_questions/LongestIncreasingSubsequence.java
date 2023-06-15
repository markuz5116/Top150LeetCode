package intermediate_questions;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        List<Integer> longestSubseq = new ArrayList<>();
        for (int num : nums) {
            if (longestSubseq.isEmpty() || longestSubseq.get(longestSubseq.size() - 1) < num) {
                longestSubseq.add(num);
                continue;
            }

            int left = 0;
            int right = longestSubseq.size() - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (longestSubseq.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            for (int i = right - 1; i <= left + 1; i++) {
                if (i < 0 || i >= longestSubseq.size()) {
                    continue;
                }
                if (longestSubseq.get(i) >= num) {
                    longestSubseq.set(i, num);
                    break;
                }
            }
        }
        return longestSubseq.size();
    }
}
