package easy_questions;

public class LowestCommonAncestorOfABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftSubRoot = null;
        TreeNode rightSubRoot = null;
        if (root.val < p.val && root.val < q.val) {
            rightSubRoot = lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            leftSubRoot = lowestCommonAncestor(root.left, p, q);
        } else {
            leftSubRoot = lowestCommonAncestor(root.left, p, q);
            rightSubRoot = lowestCommonAncestor(root.right, p, q);
        }

        if (leftSubRoot != null && rightSubRoot != null) {
            return root;
        }

        if (leftSubRoot == null && rightSubRoot == null) {
            return null;
        }

        if (leftSubRoot == null) {
            return rightSubRoot;
        }

        return leftSubRoot;
    }
}
