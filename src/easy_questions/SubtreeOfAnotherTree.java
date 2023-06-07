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
        StringBuilder rootStringBuilder = new StringBuilder();
        serialize(rootStringBuilder, root);
        String rootStr = rootStringBuilder.toString();
        System.out.println(rootStr);

        StringBuilder subRootStringBuilder = new StringBuilder();
        serialize(subRootStringBuilder, subRoot);
        String subRootStr = subRootStringBuilder.toString();
        System.out.println(subRootStr);

        return rootStr.contains(subRootStr);
    }

    private void serialize(StringBuilder stringBuilder, TreeNode root) {
        if (root == null) {
            stringBuilder.append("$");
            return;
        }

        stringBuilder.append("^");
        stringBuilder.append(root.val);
        serialize(stringBuilder, root.left);
        serialize(stringBuilder, root.right);
    }
}
