package com.cai.javademo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解处理器生成表创建语句
 * Created by reason on 17/7/2.
 */
public class TableCreator {
    public static void main(String[] args) {
        Class cl = Member.class;

        //处理类注解
        Table table = (Table) cl.getAnnotation(Table.class);
        String tableName = table.name();
        //如果表名定义为空，默认用类名作为表名
        if("".equals(tableName)){
            tableName = cl.getName().toLowerCase();
        }

        //处理字段注解
        List<String> columnDefs = new ArrayList<String>();
        for (Field field : cl.getDeclaredFields()) {
            String columnName = null;
            Annotation[] anns = field.getDeclaredAnnotations();
            if(anns.length < 1){
                //没有注解
                continue;
            }
            if(anns[0] instanceof SQLInteger){
                SQLInteger sInt = (SQLInteger) anns[0];

                //如果注解名没有定义，则取字段名为列名
                if(sInt.name().length()<1){
                    columnName = field.getName().toLowerCase();
                }else{
                    columnName = sInt.name();
                }
                columnDefs.add(columnName+" INT"+ getConstraints(sInt.constraints()));
            }

            if(anns[0] instanceof SQLString){
                SQLString sString = (SQLString) anns[0];
                if(sString.name().length()<1){
                    columnName = field.getName().toLowerCase();
                }else{
                    columnName = sString.name();
                }
                columnDefs.add(columnName+" VARCHAR("+sString.value()+")"+ getConstraints(sString.constraints()));
            }
        }
        StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
        for (String columnDef: columnDefs) {
            createCommand.append("\n" + columnDef + ",");
        }
        String tableCreate = createCommand.substring(0,createCommand.length()-1)+" );";
        System.out.println("Table Creation SQL for " + cl.getName() + " is :\n" + tableCreate);
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        //不允许为null
        if(!con.allowNull()){
            constraints += " NOT NULL";
        }
        if(con.pk()){
            constraints += " PRIMARY KEY";
        }
        if(con.unique()){
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
