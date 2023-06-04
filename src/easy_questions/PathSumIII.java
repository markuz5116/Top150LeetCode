package easy_questions;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class CountWrapper {
        int count;

        CountWrapper(int count) {
            this.count = count;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> sumToCount = new HashMap<>();
        CountWrapper countWrapper = new CountWrapper(0);
        helper(root, 0, targetSum, countWrapper, sumToCount);
        return countWrapper.count;
    }

    private void helper(TreeNode root, long currSum, int targetSum, CountWrapper countWrapper, Map<Long, Integer> sumToCount) {
        if (root == null) {
            return;
        }

        currSum += root.val;
        if (currSum == targetSum) {
            countWrapper.count++;
        }
        countWrapper.count += sumToCount.getOrDefault(currSum - targetSum, 0);

        sumToCount.put(currSum, sumToCount.getOrDefault(currSum, 0) + 1);

        helper(root.left, currSum, targetSum, countWrapper, sumToCount);
        helper(root.right, currSum, targetSum, countWrapper, sumToCount);

        sumToCount.put(currSum, sumToCount.getOrDefault(currSum, 0) - 1);
    }

}
