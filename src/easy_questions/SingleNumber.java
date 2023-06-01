package easy_questions;

import java.util.Arrays;

public class SingleNumber {
    // Given a non-empty array of integers nums, every element appears twice except
    // for one. Find that single one.
    // You must implement a solution with a linear runtime complexity and use only
    // constant extra space.
    public static int singleNumber(int[] nums) {
        int mask = 0;
        for (int num : nums) {
            mask ^= num;
        }
        return mask;
    }

    public static void test() {
        int[][] allNums = new int[][] { { 2, 2, 1 }, { 4, 1, 2, 1, 2 }, { 1 }, { -1 }, { -3, -3, -2 } };
        int[] allOutputs = new int[] { 1, 4, 1, -1, -2 };
        boolean allPass = true;
        for (int i = 0; i < allNums.length; i++) {
            int[] nums = allNums[i];
            int output = allOutputs[i];
            int myOutput = singleNumber(nums);
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
