package org.code.sort;

import org.code.utils.Utils;

import java.util.Arrays;

/**
 * 快速排序
 * 学习链接：https://juejin.im/post/5b55660ee51d4519202e2003
 */
public class QuickSortMain {
    public static void main(String[] args) {
        int[] uniqueArray = Utils.getUniqueArray(10);
        new QuickSortMain().sort(uniqueArray, 0, uniqueArray.length - 1);
        System.out.println(Arrays.toString(uniqueArray));
    }

    public int partition(int[] nums, int left, int right) {
        int temp = nums[left];
        while (left < right) {
            while (temp <= nums[right] && left < right) {
                --right;
            }
            if (left < right) {
                nums[left] = nums[right];
                ++left;
            }
            // 找到右边界
            while (temp >= nums[right] && left < right) {
                ++left;
            }
            // 交换数据
            if (left < right) {
                nums[right] = nums[left];
                --right;
            }
        }
        nums[left] = temp;
        return left;
    }

    public void sort(int[] nums, int left, int right) {
        if (nums == null || left >= right || nums.length <= 1)
            return;
        int mid = partition(nums, left, right);
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
    }
}
