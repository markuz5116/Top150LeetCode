package easy_questions;

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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + helper(root, targetSum + 0.0);
    }

    public int helper(TreeNode root, Double targetSum) {
        if (root == null) {
            return 0;
        }
        int hit = targetSum - root.val == 0 ? 1 : 0;
        return hit + helper(root.left, targetSum - root.val) + helper(root.right, targetSum - root.val);
    }

}
