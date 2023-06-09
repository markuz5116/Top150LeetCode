package easy_questions;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int peakIdx = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (peakIdx != -1) {
                    return false;
                }
                peakIdx = i;
            }
        }

        if (peakIdx == -1) {
            return true;
        }

        if (peakIdx == 0 || peakIdx == nums.length - 2) {
            return true;
        }

        return nums[peakIdx - 1] <= nums[peakIdx + 1] || nums[peakIdx] <= nums[peakIdx + 2];
    }
}
