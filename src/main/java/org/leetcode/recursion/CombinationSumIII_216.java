package org.leetcode.recursion;

import org.leetcode.utils.ListUtils;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII_216 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new CombinationSumIII_216().combinationSum3(3, 9);
        ListUtils.printEmbedList(lists);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        recurse(k, n, 1, res, new LinkedList<>());
        return res;
    }

    public void recurse(int k,
                        int remaining,
                        int startIndex,
                        LinkedList<List<Integer>> res,
                        LinkedList<Integer> path) {

        if (path.size() == k && remaining == 0) {
            res.addLast(new LinkedList<>(path));
        } else if (remaining < 0 || path.size() > k) return;

        for (int i = startIndex; i < 10; i++) {
            path.add(i);
            recurse(k, remaining - i, i + 1, res, path);
            path.removeLast();
        }
    }
}
