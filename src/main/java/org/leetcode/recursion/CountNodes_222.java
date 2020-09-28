package org.leetcode.recursion;

import org.leetcode.utils.TreeNode;

public class CountNodes_222 {
    public int countNodes(TreeNode root) {
        // if (root == null) {
        // 	return 0;
        // }
        // TreeNode l = root, r = root;
        // int lc = 0, rc = 0;
        // while (l != null) {
        // 	lc++;
        // 	l = l.left;
        // }
        // while (r != null ) {
        // 	rc++;
        // 	r = r.right;
        // }
        // if (lc == rc) {
        // 	return (int) (Math.pow(2, lc) - 1);
        // }
        // return 1 + countNodes(root.left) + countNodes(root.right);
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
