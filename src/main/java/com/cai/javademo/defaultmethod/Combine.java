package com.cai.javademo.defaultmethod;

/**
 * Created by reason on 17/12/22.
 */
public class Combine implements InterfaceA,InterfaceB {
    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.printC();
        combine.print();

    }

    @Override
    public void print() {
        InterfaceA.super.print();
    }
}
