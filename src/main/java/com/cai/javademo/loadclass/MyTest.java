package com.cai.javademo.loadclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by reason on 16/11/25.
 */
public class MyTest {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //读取本地的class文件内的字节码，转换成字节码数组
        File file = new File(".");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        FileInputStream input = new FileInputStream(file.getCanonicalPath()+"/target/classes/com/cai/javademo/loadclass/Programmer.class");
        byte[] result = new byte[1024];
        int count = input.read(result);
        //使用自定义的类加载器将byte字节码数组转换为对应的class对象
        MyClassLoader loader = new MyClassLoader();
        Class clazz = loader.defineMyClass(result, 0, count);
        System.out.println(clazz.getCanonicalName());
        Object o = clazz.newInstance();
        clazz.getMethod("code", null).invoke(o, null);

    }
}
