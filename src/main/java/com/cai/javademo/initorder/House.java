package com.cai.javademo.initorder;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by reason on 17/12/20.
 */
public class House {
    Window wi = new Window(1);
    public static Window w2 = new Window(2);
    static {
        System.out.println("执行静态块");
    }
    House(){
        System.out.println("house");
        w3 = new Window(44);
    }
    Window w3 = new Window(3);
    void f(){
        System.out.println("f()");
    }
    Window w4 = new Window(4);

}
