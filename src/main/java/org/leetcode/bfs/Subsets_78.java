package org.leetcode.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO 待实现
 */
public class Subsets_78 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(new Subsets_78().subsets(arr).toArray()));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
        dfs(ans, nums, new ArrayList<>(), 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(ans, nums, list, index + 1); // not pick the number at this index
        list.add(nums[index]);
        dfs(ans, nums, list, index + 1); // pick the number at this index
        // reverse  the current state
        list.remove(list.size() - 1);
    }
}
