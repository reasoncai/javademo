package com.cai.javademo.threadlocal;

import java.util.Collections;

/**
 * Created by reason on 17/3/13.
 */
public class Main {
    private static ThreadLocal<Integer> thd = new ThreadLocal<Integer>(){
               public Integer initialValue(){
                   System.out.println("threadlocal");
                   return 3;
               }

    };

    public static void main(String[] args) {
        System.out.println("nisa");
        thd.set(9001);
        System.out.println(thd.get());
    }
}
