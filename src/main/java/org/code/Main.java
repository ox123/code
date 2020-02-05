package org.code;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Main {
    private final int threadLocalHashCode = nextHashCode();
    private static AtomicInteger nextHashCode = new AtomicInteger();
    private static final int HASH_INCREMENT = 0x61c88647;

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    public static void main(String[] args) {
        int n = 0;
        do {
            n++;
            System.out.println(nextHashCode());
        } while (n < 5);
        AtomicStampedReference<String> reference =new AtomicStampedReference<String>("ABA",1);
        AtomicReference<String> atomicReference = new AtomicReference<String>();
//        atomicReference.
//        reference.compareAndSet()
//        nextHashCode.compareAndSet()
//        Runtime runtime = Runtime.getRuntime();
//        BigDecimal one = new BigDecimal("1.04");
//        BigDecimal two = new BigDecimal("0.42");
////        ConcurrentHashMap
//        System.out.println(one.add(two));
//        System.out.println(Main.class.getName());
//        System.out.println(new Main().getClass().getName());
//        Date date=new Date();
//        System.out.printf("%tD%n",date);
//
//        char ch1=97;
//        char ch2='a';
//        System.out.println(" ch1="+ch1);
//        System.out.println(" ch2="+ch2);
////        try {
////            Process process = runtime.exec("ifconfig");
////            System.out.println(process.exitValue());
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//        System.out.println(new Main().checkValue(6144));
//        System.out.println(new Main().checkValue(5073));
//        System.out.println(new Main().checkValue(4831));
//        System.out.println(new Main().checkValue(8300));
    }

    public static void test() {
        System.out.println("afsdfd");

    }

    boolean checkValue(int num) {
        try {

        } finally {

        }
        int d1, d2, d3;
        int checkNum, nRemain, rem;

        checkNum = num % 10;
        nRemain = num / 10;
        d3 = nRemain % 10;
        nRemain /= 10;
        d2 = nRemain % 10;
        nRemain /= 10;
        d1 = nRemain % 10;
        rem = (d1 + d2 + d3) % 7;
        return rem == checkNum;
    }
}
