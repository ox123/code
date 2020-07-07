package org.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_429 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                tmp.add(node.val);
                for (Node child :
                        node.children) {
                    queue.offer(child);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderWithDFS(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 1);
        return res;
    }

    public void dfs(Node node, List<List<Integer>> ans, int depth) {
        if (node == null) return;
        if (ans.size() < depth) {
            ans.add(new ArrayList<>());
        }
        ans.get(depth - 1).add(node.val);
        for (Node child :
                node.children) {
            dfs(child, ans, depth + 1);
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
}
