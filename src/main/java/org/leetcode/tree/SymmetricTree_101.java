package org.leetcode.tree;

import org.leetcode.utils.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree_101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetricWithRecurse(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root.left);
        stack.add(root.right);
        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;
            stack.push(left.left);
            stack.push(right.right);
            stack.push(right.left);
            stack.push(left.right);
        }
        return true;
    }

    /**
     * recurse method
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
