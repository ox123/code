package org.leetcode.tree;

import org.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSumII_113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        pathSum(root, new LinkedList<>(), paths, sum, 0);
        return paths;
    }

    private void pathSum(TreeNode root, Deque<Integer> path, List<List<Integer>> paths, int sum, int pathSum) {
        if (root == null)
            return;
        path.addLast(root.val); // path 数据添加与选择
        int currSum = pathSum + root.val;
        if ((root.left == null) && (root.right == null) && (currSum == sum))
            paths.add(new ArrayList<>(path));
        pathSum(root.left, path, paths, sum, currSum);
        pathSum(root.right, path, paths, sum, currSum);
        path.removeLast(); // 撤销原则--------
    }
//
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        List<List<Integer>> res = new LinkedList<>();
//        List<Integer> sub = new LinkedList<>();
//        recurse(root,sum,sub,res);
//        return res;
//    }
//
//    public void recurse(TreeNode root, int sum, List<Integer> sub, List<List<Integer>> res) {
//        if (root == null) return;
//        sub.add(root.val);
//        int tmp = sub.stream().mapToInt(Integer::intValue).sum();
//        if (root.left == null && root.right == null) {
//            if (tmp == sum) {
//                res.add(sub);
//            }
//            sub = new LinkedList<>();
//        }
//        recurse(root.left,sum,sub,res);
//        recurse(root.right,sum,sub,res);
//    }
}
