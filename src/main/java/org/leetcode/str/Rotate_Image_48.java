package org.leetcode.str;

import java.util.Arrays;

/**
 * TODO https://leetcode.com/problems/rotate-image/
 */
public class Rotate_Image_48 {
    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int length = matrix[0].length;
        new Rotate_Image_48().rotate(matrix);
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void rotate(int[][] matrix) {

    }
}
