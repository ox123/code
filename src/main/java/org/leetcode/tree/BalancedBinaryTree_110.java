package org.leetcode.tree;

public class BalancedBinaryTree_110 {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {

        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode node) {
        int res = 0;
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    class TreeNode {

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
}
