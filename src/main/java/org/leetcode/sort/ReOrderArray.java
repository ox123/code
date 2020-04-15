package org.leetcode.sort;

import java.util.Arrays;

public class ReOrderArray {
    public static void main(String[] args) {
        int[] num = {1, 2, 1, 4, 3, 4};
        new ReOrderArray().reOrderArray(num);
        System.out.println(Arrays.toString(num));
        new ReOrderArray().reOrderArray1(num);
        System.out.println(Arrays.toString(num));
    }

    /**
     * TODO 插入排序思想实现，找到奇数位置，然后将数插入
     *
     * @param array
     */
    public void reOrderArray1(int[] array) {
        int j = 0; // 代表奇数的位置
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                //如果是奇数的话
                if (i != j) {
                    int temp = array[i];
                    int k = i;
                    for (k = i; k > j; k--) {
                        array[k] = array[k - 1];
                    }
                    array[k] = temp;
                }
                j++;
            }
        }
    }

    /**
     * 空间复杂度O(n)，时间复杂度：O(n)
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        int len = array.length;
        int l[] = new int[len];
        int r[] = new int[len];
        int m = 0, n = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 != 0) {
                l[m] = array[i];
                m++;
            } else {
                r[n] = array[i];
                n++;
            }
        }
        for (int i = 0; i < m; i++) {
            array[i] = l[i];
        }
        for (int j = 0; j < n; j++) {
            array[m + j] = r[j];
        }
    }
}
