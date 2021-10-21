package org.nocoder.practice.tree;

import org.common.TreeNode;

/*
https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116?tpId=188&&tqId=38564&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class lowestCommonAncestor {
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {

        return help(root, o1, o2).data;
    }

    public TreeNode help(TreeNode root, int o1, int o2) {
        if (root == null || root.data == o1 || root.data == o2) {
            return root;
        }
        TreeNode left = help(root.left, o1, o2);
        TreeNode right = help(root.right, o1, o2);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
