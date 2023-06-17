package intermediate_questions;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumToAmt = new HashMap<>();
        int numSubarrays = 0;
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            if (currSum == k) {
                numSubarrays++;
            }

            numSubarrays += prefixSumToAmt.getOrDefault(currSum - k, 0);
            prefixSumToAmt.put(currSum, prefixSumToAmt.getOrDefault(currSum, 0) + 1);
        }
        return numSubarrays;
    }
}
