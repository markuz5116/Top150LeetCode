public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int numZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZeros += 1;
                continue;
            }
            nums[i - numZeros] = nums[i];
        }

        for (int i = nums.length - numZeros; i > 0 && i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
