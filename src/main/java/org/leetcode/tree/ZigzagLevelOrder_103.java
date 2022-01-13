package org.leetcode.tree;

import org.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        int size = 1;
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if (order) {
                    tmp.add(n.data);
                } else {
                    tmp.add(0, n.data);
                }
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            res.add(tmp);
            size = q.size();
            order = order ? false : true;
        }
        return res;
    }

    /**
     * https://learnku.com/articles/35513
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int level = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int length = list.size();
            res.add(new ArrayList<>());
            for (int i = 0; i < length; i++) {
                if (level % 2 == 0) {
                    TreeNode node = list.poll();
                    res.get(level).add(node.data);
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                } else {
                    TreeNode node = list.removeLast();
                    res.get(level).add(node.data);
                    if (node.right != null) {
                        list.addFirst(node.right);
                    }
                    if (node.left != null) {
                        list.addFirst(node.left);
                    }
                }
            }
            level++;
        }
        return res;
    }
}