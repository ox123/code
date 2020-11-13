package org.leetcode.tree;

import org.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = null;
        root.right = node1;
        node1.left = node2;
        List<Integer> integers = new BinaryTreePreorderTraversal_144().preorderTraversalWithRecurse(root);
        integers.forEach((item) -> {
            System.out.println(item);
        });
    }

    public List<Integer> preorderTraversalWithRecurse(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            help(root, res);
        }
        return res;
    }

    private void help(TreeNode root, List<Integer> res) {
        res.add(root.val);
        if (root.left != null) {
            help(root.left, res);
        }
        if (root.right != null) {
            help(root.right, res);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pollLast();
            res.add(pop.val);
            if (root.right != null) {
                stack.add(root.right);
            }
            if (root.left != null) {
                stack.add(root.left);
            }

        }
        return res;
    }
}
