package com.bobo.Lambda.Feature;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by bobo on 2018/8/25/11:17.
 */
public class FeatureTest1 {

    private static Random rand = new Random();
    private static long t = System.currentTimeMillis();

    static int getMoreData() {
        System.out.println("begin to start compute");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end to compute,passed " + (System.currentTimeMillis() - t));
        return rand.nextInt(1000);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() ->{
            for (int i = 0; i<100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return 0;
        });
        Future<Integer> f = future.whenComplete((Integer v, Throwable e) -> {
            System.out.println(v);
            System.out.println(e);
            long end = System.currentTimeMillis();
            System.out.println((end-start)/60);
        });
        System.out.println(f.get());

    }
}
