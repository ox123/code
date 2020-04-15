package org.leetcode.sort;

import org.leetcode.utils.Utils;

/**
 * 归并排序算法,时间复杂度n*(log(n)),
 * TODO 时间复杂度推算
 */
public class MergeSortMain {
    public static void main(String[] args) {
//        int[] array = {49, 38, 65, 97, 76, 13, 27, 50};
        int n = 5;
        int[] array = Utils.getArray(n);
        System.out.println(array.length);
//        int [] array = Utils.getArray(n);
        long start = System.currentTimeMillis();
//        new BubbleSort().sort1(array);
        mergeSort(array, 0, array.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

//        System.out.println("排好序的数组：");
//
//        for (int e : a)
//            System.out.print(e + " ");
    }

    public static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            // 获取中间节点索引值
            int mid = (left + right) >> 1;
            /**
             * 两步不断地进行分治,分治到最后只有一个数据时，然后对数据进行顺序合并
             */
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            // 合并排序后的结果
            merge(arr, left, mid, right);
        }
    }

    /**
     * 合并两个有序数组
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int length = arr.length;
        int k = left;
        int[] temp = new int[length];
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) { // 处理left到right一段数据
            if (arr[p1] <= arr[p2]) {
                temp[k++] = arr[p1++];
            } else {
                temp[k++] = arr[p2++];
            }
        }
        while (p1 <= mid) {
            temp[k++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[k++] = arr[p2++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
