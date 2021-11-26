package org.others.tree;

import org.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> tmpList = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = q.poll();
                if (tmp != null) {
                    if (tmp.left != null) {
                        q.offer(tmp.left);
                    }
                    if (tmp.right != null) {
                        q.offer(tmp.right);
                    }
                    tmpList.add(tmp.data);
                }
            }
            ans.add(tmpList);
        }
        return ans;
    }
}