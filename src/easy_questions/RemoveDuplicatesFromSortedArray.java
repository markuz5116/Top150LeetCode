package easy_questions;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int numUniques = 0;
        int uniqueIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                uniqueIdx++;
                numUniques++;
                continue;
            }

            if (nums[i] == nums[i - 1]) {
                continue;
            }

            numUniques++;
            nums[uniqueIdx] = nums[i];
            uniqueIdx++;
        }   
        return numUniques;
    }
    
}
