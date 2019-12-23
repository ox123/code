package org.code;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        BigDecimal one = new BigDecimal("1.04");
        BigDecimal two = new BigDecimal("0.42");
//        ConcurrentHashMap
        System.out.println(one.add(two));
        try {
            Process process = runtime.exec("ifconfig");
            System.out.println(process.exitValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
