package org.leetcode.recursion;

import org.leetcode.utils.ListUtils;

import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {


    public static void main(String[] args) {
        List<List<Integer>> combine = new Combinations_77().combine(4, 2);
        System.out.println(combine.size());
        ListUtils.printEmbedList(combine);
    }

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        recurse(n, k, 1, res, path);
        return res;
    }

    public void recurse(int n, int k, int startIndex, LinkedList<List<Integer>> res, LinkedList<Integer> path) {
        if (path.size() == k) { // 如果满足条件，则添加到对应的结果集中
            res.addLast(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i); // 选择对应的数据
            recurse(n, k, i + 1, res, path);
            path.removeLast(); // 撤销选择的数据
        }
    }
}
