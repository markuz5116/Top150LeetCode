package easy_questions;

public class SubtreeOfAnotherTree {
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null || root == null) {
            return root == subRoot;
        }

        boolean hasSubTree = false;
        if (root.val == subRoot.val) {
            hasSubTree = helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
        }

        if (hasSubTree) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean helper(TreeNode root, TreeNode subRoot) {
        if (subRoot == null || root == null) {
            return root == subRoot;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return helper(root.left, subRoot.left) && helper(root.right, subRoot.right);
    }
}
