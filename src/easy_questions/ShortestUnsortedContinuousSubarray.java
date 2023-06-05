package easy_questions;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int leftIdx = -1;
        int rightIdx = -1;
        int minElem = -1;
        int maxElem = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (leftIdx == -1) {
                    leftIdx = i - 1;
                    maxElem = nums[i - 1];
                    minElem = nums[i];
                } 
                rightIdx = i;
                if (maxElem < nums[i - 1]) {
                    maxElem = nums[i - 1];
                }
                if (minElem > nums[i]) {
                    minElem = nums[i];
                }
            }

            if (nums[i] < maxElem) {
                rightIdx = i;
            }
            if (nums[i] < minElem) {
                rightIdx = i;
            }
        }

        if (leftIdx == -1) {
            return 0;
        }

        for (int i = 0; i < leftIdx; i++) {
            if (i == 0) {
                if (nums[i] > minElem) {
                    leftIdx = 0;
                    break;
                }
                continue;
            }
            if (nums[i] >= minElem) {
                leftIdx = i;
                break;
            }
        }

        return rightIdx - leftIdx + 1;
    }
}
