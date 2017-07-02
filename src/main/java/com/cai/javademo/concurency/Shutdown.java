package com.cai.javademo.concurency;

import java.util.concurrent.TimeUnit;

/**
 * 安全地终止线程
 * Created by reason on 17/6/17.
 */
public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner runner1 = new Runner();
        Thread countThread = new Thread(runner1);
        countThread.start();
        //方法1：中断
        //睡眠1秒，main线程对countThread进行中断，使其能感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

        Runner runner2 = new Runner();
        countThread = new Thread(runner2);
        countThread.start();
        //方法2：设置标志位（推荐）
        //睡眠1秒，main线程对countThread进行取消，使其感知on为false而结束
        TimeUnit.SECONDS.sleep(1);
        runner2.cancel();
    }

    private static class Runner implements Runnable {
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while(on && !Thread.currentThread().isInterrupted()){
                i ++;
            }
            System.out.println("count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
