package org.leetcode.sort;

import org.leetcode.utils.Utils;

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

    /**
     * 获取partition值
     * @param nums
     * @param left
     * @param right
     * @return
     */
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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 优化后的获取中轴值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition1(int[] arr, int left, int right) {
        // 采用三数中值分割法
        int mid = left + (right - left) / 2;
        // 保证左端较小
        if (arr[left] > arr[right])
            swap(arr, left, right);
        // 保证中间较小
        if (arr[mid] > arr[right])
            swap(arr, mid, right);
        // 保证中间最小，左右最大
        if (arr[mid] > arr[left])
            swap(arr, left, mid);
        int pivot = arr[left];
        while (right > left) {
            // 先判断基准数和后面的数依次比较
            while (pivot <= arr[right] && left < right) {
                --right;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (left < right) {
                arr[left] = arr[right];
                ++left;
            }
            // 现在是 arr[right] 需要填坑了
            while (pivot >= arr[left] && left < right) {
                ++left;
            }
            if (left < right) {
                arr[right] = arr[left];
                --right;
            }
        }
        arr[left] = pivot;
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
