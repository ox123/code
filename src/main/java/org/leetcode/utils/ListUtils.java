package org.leetcode.utils;

import java.util.List;

public class ListUtils {

    public static void printList(List<Integer> list) {
        for (Integer x :
                list) {
            System.out.println(x);
        }
    }

    public static void printEmbedList(List<List<Integer>> list) {
        for (List<Integer> lst : list) {
            StringBuilder builder = new StringBuilder();
            for (Integer x :
                    lst) {
                builder.append(x);
            }
            System.out.println(builder.toString());
        }
    }
}
