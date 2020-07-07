package org.leetcode.tree;

import org.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        traverse(root.right, list);
        list.add(root.val);
    }
}
