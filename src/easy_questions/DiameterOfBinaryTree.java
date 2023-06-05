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

        int[] maxPossDiameter = helper(root);
        return maxPossDiameter[0];
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 };
        }

        int[] leftDiameter = helper(node.left);
        int[] rightDiameter = helper(node.right);
        int[] nodeDiameter = new int[2];
        
        nodeDiameter[0] = 1 + leftDiameter[1] + rightDiameter[1];
        nodeDiameter[0] = Integer.max(nodeDiameter[0], leftDiameter[0]);
        nodeDiameter[0] = Integer.max(nodeDiameter[0], rightDiameter[0]); 

        nodeDiameter[1] = 1 + Integer.max(leftDiameter[1], rightDiameter[1]);

        return nodeDiameter;
    }
}
