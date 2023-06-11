package easy_questions;

public class PathSum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        boolean isLeaf = root.left == null && root.right == null;
        targetSum -= root.val;
        if (isLeaf && targetSum == 0) {
            return true;
        }

        if (isLeaf && targetSum != 0) {
            return false;
        }

        return hasPathSum(root.left, targetSum) || 
            hasPathSum(root.right, targetSum);
    }
}
