package org.basic.test;

import java.util.Arrays;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {

//    int len = Integer.parseInt(args[0]);
        int len = 100000;
//    /* Exit if program was started without size for array */
//    if (args.length == 0) {
//      System.out.println("No array size... Exiting...");
//      System.exit(1);
//    }

        // Initialize variables
        long begin, end;
        Random rand = new Random();

        /* Generate random integer array with given length */
        int length = Math.max(0, len);
        int[] array = new int[length];
        java.util.Arrays.setAll(array, i -> rand.nextInt());
        int[] arrayBackUp = Arrays.copyOf(array, array.length);

        /* Built in sort */
        begin = System.currentTimeMillis();
        int[] sortedDefault = array.clone();
        Arrays.sort(sortedDefault);
        end = System.currentTimeMillis();
        System.out.println("Arrays.sort(): " + (end - begin) + "ms");

        /* Sort using sorting algorithm provided by 'Task1' */
        begin = System.currentTimeMillis();
        int[] sortedTask1 = Task1.sort(array);
        end = System.currentTimeMillis();
        System.out.println("sort1: " + (end - begin) + "ms");

        /* Sort using 'sort2' */
        begin = System.currentTimeMillis();
        int[] sortedTask2 = Task2.sort(array);
        end = System.currentTimeMillis();
        System.out.println("sort2: " + (end - begin) + "ms");

        Integer[] arr = new Integer[array.length];
        int index=0;
        for (int i :
                array) {
            arr[index++] = i;
        }
        /* Sort using 'sort2' */
        begin = System.currentTimeMillis();
        MergeSort.mergeSort(arr, 0, arr.length-1);
        end = System.currentTimeMillis();
        System.out.println("sort3: " + (end - begin) + "ms");
        /* Check correctness (use -ea flag to enable) */
        assert Arrays.equals(array, arrayBackUp);
        assert Arrays.equals(sortedDefault, sortedTask1);
        assert Arrays.equals(sortedDefault, sortedTask2);

    }

}
