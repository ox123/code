package org.leetcode.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class MaxWindows {
    /**
     * O(arr*w)
     *
     * @param arr
     * @param w
     * @return
     */
    public int[] getMaxWindow1(int arr[], int w) {
        int res[] = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i <= arr.length - w; i++) {
            int max = 0;
            for (int j = 0; j < w; j++) {
                max = Math.max(max, arr[i + j]);
            }
            res[index++] = max;
        }
        return res;
    }

    /**
     * o(n)
     *
     * @param arr
     * @param w
     * @return
     */
    public int[] getMaxWindow(int arr[], int w) {
        if (arr == null || arr.length < w || w < 1) {
            return null;
        }
        int res[] = new int[arr.length - w + 1];
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int n = 10000000;
        int res[] = {4, 3, 5, 4, 3, 3, 6, 7};
        for (int i = 0; i < n; i++) {
            res[i] = new Random().nextInt() % n;
        }
        int w = 2;
        System.out.println(Arrays.toString(res));
    }
}
