package com.czk.hope.entity.model;

import lombok.ToString;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:17
 */
@ToString
@Proxy(lazy = false)
@Entity
public class Users {
    private int id;
    private String name;
    private String sex;
    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Users users = (Users) object;

        if (id != users.id) return false;
        if (age != users.age) return false;
        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        if (sex != null ? !sex.equals(users.sex) : users.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
