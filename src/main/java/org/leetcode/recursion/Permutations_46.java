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

    /**
     * 另外一种思路
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums.length == 0) {
            return permutations;
        }

        collectPermutations(nums, 0, new ArrayList<>(), permutations);
        return permutations;
    }

    private void collectPermutations(int[] nums, int start, List<Integer> permutation,
                                     List<List<Integer>>  permutations) {

        if (permutation.size() == nums.length) {
            permutations.add(permutation);
            return;
        }

        for (int i = 0; i <= permutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(i, nums[start]);
            collectPermutations(nums, start + 1, newPermutation, permutations);
        }
    }
}
