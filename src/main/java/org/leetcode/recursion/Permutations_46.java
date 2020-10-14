package org.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯与深度搜索案例
 */
public class Permutations_46 {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        System.out.println(new Permutations_46().permute(num));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), new boolean[nums.length], res, nums);
        return res;
    }

    private void dfs(ArrayList<Integer> list, boolean[] used, List<List<Integer>> res, int[] nums) {
        if (list.size() == used.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            dfs(list, used, res, nums);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
