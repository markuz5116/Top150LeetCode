package intermediate_questions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, ArrayList<Integer> currCombi, int[] candidates, int target, int i) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(currCombi));
            return;
        }

        for (; i < candidates.length; i++) {
            int candidate = candidates[i];
            currCombi.add(candidate);
            helper(ans, currCombi, candidates, target - candidate, i);
            currCombi.remove(currCombi.size() - 1);
        }
    }
}
