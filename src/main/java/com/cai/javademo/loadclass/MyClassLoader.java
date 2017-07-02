package com.cai.javademo.loadclass;

/**
 * 自定义一个类加载器，用于将字节码转换成class对象
 * Created by reason on 16/11/25.
 */
public class MyClassLoader extends ClassLoader {
    public Class<?> defineMyClass(byte[] b, int off, int len){
        return super.defineClass(b, off, len);
    }
}
