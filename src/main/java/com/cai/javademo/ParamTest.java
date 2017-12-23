package com.cai.javademo;

import com.sun.tools.javac.tree.TreeInfo;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * Created by reason on 17/5/28.
 */
public class ParamTest {
    public static void main(String[] args) {
        /**
         * 测试1：方法不能修改基本类型的参数
         */
        int percent = 1;
        System.out.println("方法之前：percent="+ percent);
        addValue(percent);
        System.out.println("方法之后：percent="+ percent);
    }
    public static void addValue(int x){
        x = x + 1;
        System.out.println("方法addValue里x="+x);
    }
    class Employee{
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public void raiseSalary(double byPercent){
            double raise = salary * byPercent / 100;
                    salary += raise;
        }
    }
}
