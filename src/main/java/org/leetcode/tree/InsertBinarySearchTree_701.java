package org.leetcode.tree;

import org.leetcode.utils.TreeNode;

public class InsertBinarySearchTree_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public TreeNode insertIntoBSTWithOptimized(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) return node;
        TreeNode current = root;
        while (current.val != val) {
            if (current.val > val) {
                if (current.left == null) {
                    current.left = node;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                }
                current = current.right;
            }
        }
        return root;
    }
}
