package org.code.tree;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/submissions/
 */
public class MergeTwoBinaryTrees_617 {
    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = t1;
        if (t1 == null) return t2;
        else if (t2 != null) {
            root.val = t1.val + t2.val;
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        return root;
    }
}
