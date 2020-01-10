package org.code.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {52, 63, 14, 59, 68, 35, 8, 67, 45, 99};
        System.out.println(Arrays.toString(new SelectSort().sort(array)));
    }

    public int[] sort(int arr[]) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            // 找到i之后的最小值
            for (int j = i + 1; j < length - 1; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 比较如果当前最小值索引发生变化则交换两个数，保持前半段一直是最小值
            if (min != i) {
                //交换值
                swap(arr, i, min);
            }
        }
        return arr;
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
