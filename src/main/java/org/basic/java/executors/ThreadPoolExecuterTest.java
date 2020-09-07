package org.basic.java.executors;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadPoolExecuterTest {
    public static void main(String[] args) {
        /**
         *        return new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>());
         *
         *     ->>>> this(Integer.MAX_VALUE);
         *     讲导致队列中数据不停增大，最后导致OOM异常，不能直接new此来实现
         */
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        printStats(threadPoolExecutor);
        for (int i = 0; i < 100000000; i++) {
            threadPoolExecutor.execute(() -> {
                String payload = IntStream.rangeClosed(1, 1000000)
                        .mapToObj(__ -> "a")
                        .collect(Collectors.joining("")) + UUID.randomUUID().toString();
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException exception) {
//                    exception.printStackTrace();
//                }

            });
        }
        threadPoolExecutor.shutdown();
        try {
            threadPoolExecutor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    private static void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            System.out.println(threadPool.getPoolSize());
            System.out.println(threadPool.getActiveCount());
            System.out.println(threadPool.getCompletedTaskCount());
            System.out.println(threadPool.getQueue().size());
        }, 0, 1, TimeUnit.SECONDS);
    }
}