package com.cai.javademo.proxy;

import java.awt.*;

/**
 * Created by reason on 16/11/25.
 */
public interface FontProvider {
    Font getFont(String name);
    default  void test(String ok){
        System.out.println("d");
    }
}
