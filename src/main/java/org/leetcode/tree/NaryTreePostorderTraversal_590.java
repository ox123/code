package org.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal_590 {
    public static void main(String[] args) {

    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    public void traverse(Node node, List<Integer> res) {
        if (node != null || node.children != null) {
            res.add(node.val);
            for (Node n :
                    node.children) {
                traverse(n, res);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
