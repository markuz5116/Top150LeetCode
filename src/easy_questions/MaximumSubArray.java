package easy_questions;

public class MaximumSubArray {
    // Given an integer array nums, find the subarray with the largest sum, and
    // return its sum.
    public static int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            currSum += num;
            if (currSum < num) {
                currSum = num;
            }
            if (currSum > maxSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }

    public static void test() {
        int[][] allNums = new int[][] { { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, { 1 }, { 5, 4, -1, 7, 8 } };
        int[] allOutputs = new int[] { 6, 1, 23 };
        boolean allPass = true;
        for (int i = 0; i < allNums.length; i++) {
            int[] nums = allNums[i];
            int output = allOutputs[i];
            int myOutput = MaximumSubArray.maxSubArray(nums);
            if (myOutput != output) {
                System.out.println(String.format("Your code gave: %s", myOutput));
                System.out.println(String.format("Correct output: %s", output));
                allPass = false;
            }
        }
        if (allPass) {
            System.out.println("All Correct");
        }

    }
}
