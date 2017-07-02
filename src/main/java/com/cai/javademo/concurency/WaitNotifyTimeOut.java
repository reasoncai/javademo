package com.cai.javademo.concurency;

import java.util.Date;

/**
 * Created by reason on 17/6/17.
 */
public class WaitNotifyTimeOut {
    private static boolean flag = true;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        //睡眠时间大于超时时间，使其超时
        Thread.sleep(5000);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();

    }

    private static class Wait implements Runnable {
        //超时时间
        private long remaining = 2000 ;

        @Override
        public void run() {
            //加锁,拥有lock的Monitor
            synchronized (lock) {
                    long future = System.currentTimeMillis() + remaining;
                    while(true && remaining > 0) {
                        System.out.println(Thread.currentThread() + " wait @ " + new Date() + flag);
                        try {
                            //设置2秒超时返回
                            lock.wait(remaining);
                            remaining = future - System.currentTimeMillis();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                System.out.println(Thread.currentThread() + " running @ "+ new Date()+flag);
            }
        }
    }

    private static class Notify implements Runnable{

        @Override
        public void run() {
            //加锁,拥有lock的Monitor
            synchronized (lock){
                //获取lock的锁，然后进行通知，通知时不会释放lock的锁
                //直到当前线程释放了lock后，waitThread才能从wait方法中返回
                System.out.println(Thread.currentThread()+" hold lock.notify @ "+new Date());
                flag = false;
                lock.notifyAll();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
