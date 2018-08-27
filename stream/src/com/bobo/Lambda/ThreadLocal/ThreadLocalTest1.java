package com.bobo.Lambda.ThreadLocal;

/**
 * @author wuxiaobo@didachuxing.com
 * Created by bobo on 2018/8/27/13:59.
 */
public class ThreadLocalTest1 {

    public static void main(String[] args) {

        ThreadLocal<Long> threadLocal = new ThreadLocal<>();
        threadLocal.set(Thread.currentThread().getId());
        System.out.println("main thread id ===="+Thread.currentThread().getId());
        new Thread(() -> {
           threadLocal.set(Thread.currentThread().getId());
           System.out.println("new Thread id ====="+Thread.currentThread().getId());
        }).start();

        System.out.println(threadLocal.get());
    }
}
