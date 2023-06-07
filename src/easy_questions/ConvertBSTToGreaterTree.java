package easy_questions;

public class ConvertBSTToGreaterTree {
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

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        root.val += getTotalVal(root.right, 0);
        getTotalVal(root.left, root.val);
        return root;
    }

    private int getTotalVal(TreeNode root, int currVal) {
        if (root == null) {
            return 0;
        }

        int rightTotal = getTotalVal(root.right, currVal);
        root.val += rightTotal + currVal;
        int leftTotal = getTotalVal(root.left, root.val);
        
        return leftTotal + root.val - currVal;
    }
}
