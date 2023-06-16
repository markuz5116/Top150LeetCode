package intermediate_questions;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int prefix = 1;
        int suffix = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] *= prefix;
            prefix *= nums[i];

            ans[nums.length - 1 - i] *= suffix;
            suffix *= nums[nums.length - 1 - i];
        }
        return ans;
    }
}
