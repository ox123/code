package org.leetcode.tree;

public class HasPathSum_112 {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }

    public boolean dfs(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        sum -= node.val;
        if (node.left == null && node.right == null) {
            return sum == 0;
        }
        return dfs(node.left, sum) || dfs(node.right, sum);
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
