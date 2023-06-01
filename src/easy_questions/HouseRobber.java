package easy_questions;

import java.util.Arrays;

public class HouseRobber {
    // You are a professional robber planning to rob houses along a street. Each
    // house has a certain amount of money stashed, the only constraint stopping you
    // from robbing each of them is that adjacent houses have security systems
    // connected and it will automatically contact the police if two adjacent houses
    // were broken into on the same night.

    // Given an integer array nums representing the amount of money of each house,
    // return the maximum amount of money you can rob tonight without alerting the
    // police.
    public static int rob(int[] nums) {
        int maxAmtWithoutCurr = 0;
        int maxAmtWithCurr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempWithoutCurr = Integer.max(maxAmtWithoutCurr, maxAmtWithCurr);
            maxAmtWithCurr = maxAmtWithoutCurr + nums[i];
            maxAmtWithoutCurr = tempWithoutCurr;
        }
        return Integer.max(maxAmtWithoutCurr, maxAmtWithCurr);
    }

    public static void test() {
        int[][] allNums = new int[][] { { 1, 2, 3, 1 }, { 2, 7, 9, 3, 1 } };
        int[] allOutputs = new int[] { 4, 12 };
        boolean allPass = true;
        for (int i = 0; i < allNums.length; i++) {
            int[] nums = allNums[i];
            int output = allOutputs[i];
            int myOutput = HouseRobber.rob(nums);
            if (myOutput != output) {
                System.out.println(String.format("Input: %s", Arrays.toString(nums)));
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
