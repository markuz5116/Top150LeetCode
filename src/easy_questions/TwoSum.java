package easy_questions;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    // Given an array of integers nums and an integer target, return indices of the
    // two numbers such that they add up to target.
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> remainderToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (remainderToIdx.containsKey(num)) {
                int storedIdx = remainderToIdx.get(num);
                return new int[] { storedIdx, i };
            }
            int remainder = target - num;
            remainderToIdx.put(remainder, i);
        }
        return new int[2];
    }

    public static void test() {
        int[][] allNums = new int[][] { { 2, 7, 11, 15 }, { 3, 2, 4 }, { 3, 3 } };
        int[] allTargets = new int[] { 9, 6, 6 };
        int[][] allOutputs = new int[][] { { 0, 1 }, { 1, 2 }, { 0, 1 } };
        boolean allPass = true;
        for (int i = 0; i < allNums.length; i++) {
            int[] nums = allNums[i];
            int target = allTargets[i];
            int[] output = allOutputs[i];
            int[] myOutput = TwoSum.twoSum(nums, target);
            if (!Arrays.equals(myOutput, output)) {
                System.out.println(String.format("Your code gave: %s", Arrays.toString(myOutput)));
                System.out.println(String.format("Correct output: %s", output));
                allPass = false;
            }
        }
        if (allPass) {
            System.out.println("All Correct");
        }
    }
}
