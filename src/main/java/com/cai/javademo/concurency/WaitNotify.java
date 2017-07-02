package com.cai.javademo.concurency;

import java.util.Date;

/**
 * Created by reason on 17/6/17.
 */
public class WaitNotify {
    private static boolean flag = true;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        Thread.sleep(1000);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();

    }

    private static class Wait implements Runnable {

        @Override
        public void run() {
            //加锁,拥有lock的Monitor
            synchronized (lock) {
                //当条件不满足时，继续wait,同时释放了lock的锁
                while (flag){
                    System.out.println(Thread.currentThread() + " flag is true. wait @ "+ new Date());
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. running @ "+ new Date());
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
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //Thread.yield();
            //再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread()+" hold lock again. @"+new Date());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
