package org.code.sort;

import org.code.utils.Utils;

import java.util.Arrays;

/**
 * 参考地址：https://blog.csdn.net/zdp072/article/details/44221803
 */
public class InsertSort {
    public static void main(String[] args) {
//        Integer i = 127;
//        Integer j = 127;
//        System.out.println(i == j);
        int[] array = Utils.getUniqueArray(10);

        System.out.println(Arrays.toString(new InsertSort().sort(array)));
    }

    public int[] sort(int[] nums) {
        //默认构造从左→右依次递增的序列
        for (int i = 1; i < nums.length; i++) {
            int j;
            int temp = nums[i];                      //temp是本趟待插入的数，之前从0~i-1的数全是从左→右有序递增。
            for (j = i - 1; j >= 0 && nums[j] > temp; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
            System.out.println("第" + i + "次直接插入排序后的数组：");
        }
        return nums;
    }
}
