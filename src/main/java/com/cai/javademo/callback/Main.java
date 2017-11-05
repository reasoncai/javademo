package com.cai.javademo.callback;

/**
 * java回调设计
 * Created by reason on 17/11/5.
 */
public class Main {
    public static void main(String[] args) {
        Student jack = new Jack();
        Teacher teacher = new Teacher(jack);
        teacher.askQuestion();


    }
}
