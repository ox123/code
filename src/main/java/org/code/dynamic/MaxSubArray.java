package org.code.dynamic;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, -2, 5, -3, -1, 7, 4, -6};
        System.out.println(new MaxSubArray().maxSubArray(arr));
    }

    public int maxSubArray(int arr[]) {
        int length = arr.length;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (sum > 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
