package easy_questions;

import java.util.HashMap;
import java.util.Map;

public class LongestUnivaluePath {
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

    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }

        int leftPath = helper(root.left, res);
        int rightPath = helper(root.right, res);

        int leftArrow = 0;
        if (root.left != null && root.left.val == root.val) {
            leftArrow += leftPath + 1;
        }
        int rightArrow = 0;
        if (root.right != null && root.right.val == root.val) {
            rightArrow += rightPath + 1;
        }

        res[0] = Integer.max(leftArrow + rightArrow, res[0]);
        return Integer.max(leftArrow, rightArrow);
    }
}
