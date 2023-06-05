package easy_questions;

import javax.swing.text.html.HTMLDocument.RunElement;

public class DiameterOfBinaryTree {
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

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[] { 0 };
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }

        int maxLeftLevel = helper(root.left, res);
        int maxRightLevel = helper(root.right, res);

        res[0] = Integer.max(res[0], maxLeftLevel + maxRightLevel);

        return Integer.max(maxLeftLevel, maxRightLevel) + 1;
    }
}
