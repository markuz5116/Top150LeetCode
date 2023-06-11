package intermediate_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (left != i + 1 && nums[left - 1] == nums[left]) {
                    left++;
                    continue;
                }

                if (right != nums.length - 1 && nums[right + 1] == nums[right]) {
                    right--;
                    continue;
                }

                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> oneAns = new ArrayList<>();
                    oneAns.add(nums[i]);
                    oneAns.add(nums[left]);
                    oneAns.add(nums[right]);
                    ans.add(oneAns);
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
