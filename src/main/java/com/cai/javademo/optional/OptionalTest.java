package com.cai.javademo.optional;

import java.util.Optional;

/**
 * Created by reason on 17/9/27.
 */
public class OptionalTest {
    public static void main(String[] args) throws Exception {
        Student student = getNull();
        Student defaultStudent = getStudent();
        Optional<Student> studentOptional = Optional.ofNullable(student);
        Student student1 = studentOptional.orElse(getDefaultStudent());
        System.out.println(student1);
        Student student2 = studentOptional.orElseGet(() -> getFuntionStudent());
        System.out.println(student2);
        //Student student3 = studentOptional.orElseThrow(() -> new Exception("空抛出自定义异常"));
       // System.out.println(student3.toString());

        //若存在则进行某种操作（这里将名字改为modify）
        studentOptional.ifPresent((x) -> {
            x.setName("modify");
        });
//        System.out.println(studentOptional.get());

        //map函数(这里将获取名字并转大写)无限级联
        String s = studentOptional.map(a -> a.getName()).map(b -> b.toUpperCase()).orElse(null);
        System.out.println(s);
    }

    private static Student getStudent() {
        Student student = new Student();
        student.setName("normal");
        student.setAge(10);
        return student;
    }

    private static Student getNull() {
        return null;
    }

    private static Student getDefaultStudent() {
        Student student = new Student();
        student.setName("default");
        student.setAge(1);
        return student;
    }

    private static Student getFuntionStudent() {
        Student student = new Student();
        student.setName("Funtion");
        student.setAge(129000);
        return student;
    }
}
