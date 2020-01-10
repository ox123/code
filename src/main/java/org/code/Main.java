package org.code;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        BigDecimal one = new BigDecimal("1.04");
        BigDecimal two = new BigDecimal("0.42");
//        ConcurrentHashMap
        System.out.println(one.add(two));
        System.out.println(Main.class.getName());
        System.out.println(new Main().getClass().getName());
//        try {
//            Process process = runtime.exec("ifconfig");
//            System.out.println(process.exitValue());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
