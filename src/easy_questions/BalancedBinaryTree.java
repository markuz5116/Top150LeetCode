package easy_questions;

public class BalancedBinaryTree {
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == Integer.MAX_VALUE || rightHeight == Integer.MAX_VALUE) {
            return false;
        }

        return Math.abs(getHeight(root.left) - getHeight(root.right)) < 2;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (leftHeight == Integer.MAX_VALUE || rightHeight == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (Math.abs(rightHeight - leftHeight) >= 2) {
            return Integer.MAX_VALUE;
        }

        return 1 + Integer.max(leftHeight, rightHeight);
    }
}
