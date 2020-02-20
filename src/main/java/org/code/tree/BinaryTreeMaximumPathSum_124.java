package org.code.tree;

import org.code.utils.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum_124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left= new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        int maxValue = new BinaryTreeMaximumPathSum_124().maxPathSum(root);
        System.out.println(maxValue);
    }

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        trace(root);
        return max;
    }

    public int trace(TreeNode root) {
        if (root == null) return 0;
        int left = trace(root.left);
        int right = trace(root.right);
        max = Math.max(root.val + left + right, max);
        // 终止条件比较难想到
        int tmp = root.val + Math.max(left, right);
        return tmp < 0 ? 0 : tmp;
    }
}
