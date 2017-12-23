package com.cai.javademo.defaultmethod;

/**
 * Created by reason on 17/12/22.
 */
public interface InterfaceB {
    default void print(){
        System.out.println("B");
    }
}
