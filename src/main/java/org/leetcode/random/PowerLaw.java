package org.leetcode.random;

import java.util.Random;

public class PowerLaw {
    private static final double ZSKIPLIST_P = 0.25;
    private static final int ZSKIPLIST_MAXLEVEL = 64;

    public static void main(String[] args) {
        System.out.println(new PowerLaw().zslRandomLevel());
    }

    /**
     * rediso中获取层高的算法
     * 0xFFFF  64位系统为65536
     * @return
     */
    int zslRandomLevel() {
        int level = 1;
        while ((new Random().nextInt() & 0xFFFF) < (ZSKIPLIST_P * 0xFFFF))
            level += 1;
        return (level < ZSKIPLIST_MAXLEVEL) ? level : ZSKIPLIST_MAXLEVEL;
    }
}
