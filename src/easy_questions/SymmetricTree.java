package easy_questions;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
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

    public class Pair {
        TreeNode first;
        TreeNode second;

        Pair(TreeNode first, TreeNode second) {
            this.first = first;
            this.second = second;
        }
    }

    // Given the root of a binary tree, check whether it is a mirror of itself
    // (i.e., symmetric around its center).
    public static boolean isSymmetric(TreeNode root) {
        return isSymmetricRec(root.left, root.right) && isSymmetricIter(root);
    }

    private static boolean isSymmetricIter(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new SymmetricTree().new Pair(root.left, root.right));
        while (!queue.isEmpty()) {
            Pair nodes = queue.poll();
            if (nodes.first == null && nodes.second == null) {
                continue;
            }

            if (nodes.first == null || nodes.second == null) {
                return false;
            }

            if (nodes.first.val != nodes.second.val) {
                return false;
            }

            queue.add(new SymmetricTree().new Pair(nodes.first.left, nodes.second.right));
            queue.add(new SymmetricTree().new Pair(nodes.first.right, nodes.second.left));
        }
        return true;
    }

    private static boolean isSymmetricRec(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetricRec(left.left, right.right) && isSymmetricRec(left.right, right.left);
    }

}
