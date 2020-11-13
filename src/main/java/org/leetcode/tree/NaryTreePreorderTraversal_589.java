package org.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal_589 {
    public List<Integer> preorderWithStack(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            res.add(pop.val);
            for (int i = pop.children.size() - 1; i >= 0; i--) {
                stack.push(pop.children.get(i));
            }
        }
        return res;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root != null) {
            help(root, res);
        }
        return res;
    }

    private void help(Node root, List<Integer> res) {
        res.add(root.val);
        if (root.children != null) {
            List<Node> children = root.children;
            for (Node node :
                    children) {
                help(node, res);
            }
        }
    }
}
