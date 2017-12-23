package com.cai.javademo.defaultmethod;

/**
 * Created by reason on 17/12/22.
 */
public interface InterfaceA {
    default void print(){
        System.out.println("A");
    }

    default void printC(){
        System.out.println("C");
    }
}
