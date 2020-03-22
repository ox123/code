package org.code.str;

public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new RemoveElement_27().removeElement(arr, 2));
    }

    public int removeElement(int[] nums, int val) {
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
