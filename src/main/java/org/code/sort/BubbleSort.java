package org.code.sort;

import org.code.utils.Utils;

public class BubbleSort {
    public static void main(String[] args) {
        int n = 100000;
        int a[] = Utils.getArray(n);
        long start = System.currentTimeMillis();
        new BubbleSort().sort1(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        System.out.println(Arrays.toString(new BubbleSort().sort(a)));
    }

    public int[] sort(int arr[]) {
        int length = arr.length;
        int result[] = new int[length];
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 优化不必要的比较
     *
     * @param arr
     * @return
     */
    public int[] sort1(int arr[]) {
        int length = arr.length;
        int result[] = new int[length];
        for (int i = 0; i < length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }
}
