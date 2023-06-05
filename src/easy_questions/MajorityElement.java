package easy_questions;

public class MajorityElement {
    // Given an array nums of size n, return the majority element.
    public int majorityElement(int[] nums) {
        int majorityElem = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (count == 0) {
                majorityElem = num;
            }

            if (majorityElem == num) {
                count++;
            } else {
                count--;
            }
        }
        return majorityElem;
    }
}
