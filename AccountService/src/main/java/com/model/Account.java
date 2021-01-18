package com.model;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

/**
 * Created by CoT on 10/14/17.
 */

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column
    @NotNull
    private int age;

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
