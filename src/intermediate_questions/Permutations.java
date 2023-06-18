package intermediate_questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), new HashSet<>(), nums);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> currCombi, Set<Integer> usedNums, int[] nums) {
        if (usedNums.size() == nums.length) {
            ans.add(List.copyOf(currCombi));
            return;
        }

        for (int num : nums) {
            if (usedNums.contains(num)) {
                continue;
            }

            currCombi.add(num);
            usedNums.add(num);
            helper(ans, currCombi, usedNums, nums);
            currCombi.remove(currCombi.size() - 1);
            usedNums.remove(num);
        }
    }
}
