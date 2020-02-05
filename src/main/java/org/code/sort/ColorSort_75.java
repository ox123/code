package org.code.sort;

import java.util.Arrays;

public class ColorSort_75 {
    public static void main(String[] args) {
        int num[] = new int[]{1, 1, 0, 0, 2, 2};
        new ColorSort_75().sortColors(num);
//        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
    }

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
            } else if (nums[i] == 2) {
                swap(nums, right, i);
                right--;
                i--;
            }
        }
    }

    public void sortColor1(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
