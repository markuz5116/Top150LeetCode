package easy_questions;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    // Given an array nums of n integers where nums[i] is in the range [1, n],
    // return an array of all the integers in the range [1, n] that do not appear in
    // nums.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = nums[i];
            if (idx < 0) {
                idx *= -1;
            }
            idx -= 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        List<Integer> missingNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missingNums.add(i + 1);
            }
        }
        return missingNums;
    }
}
