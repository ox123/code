package org.leetcode.tree;

import org.leetcode.utils.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);

    }
}
