package com.cai.javademo.annotation;

/**
 * 会员实体类
 * Created by reason on 17/7/2.
 */
@Table(name = "member")
public class Member {
    @SQLString(value = 30,name="id",constraints = @Constraints(pk = true))
    private String id;
    @SQLString(50)
    private String name;
    @SQLInteger
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
