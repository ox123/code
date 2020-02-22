package org.code.utils;

import java.util.*;

public class Utils {

    public static int[] getUniqueArray(int n) {
        List<Integer> generated = new ArrayList<>();
        Random random = new Random();
        Set<Integer> result = new LinkedHashSet<Integer>();
        while (result.size() < n) {
            int i = random.nextInt();
            Integer next = i > 0 ? i % n*12 : -i % n*10;
            result.add(next);
        }
        int[] a = new int[result.size()];
        int i = 0;
        for (Integer item :
                result) {
            a[i++] = item;
        }
        System.out.println(Arrays.toString(a));
        return a;
    }

    public static int[] getArray(int n) {
        int a[] = new int[n];
        List<Integer> list = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            int i1 = new Random().nextInt(i + 1);
            a[i] = i1;
        }
        System.out.println(Arrays.toString(list.toArray()));
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Utils.getUniqueArray(5)));
    }
}
