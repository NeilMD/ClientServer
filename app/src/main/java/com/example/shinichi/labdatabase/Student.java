package com.example.shinichi.labdatabase;

/**
 * Created by shinichi on 2/9/17.
 */

public class Student {

    // CREATE TABLE IF NOT EXIST student
    // id int pk

    // SELECT id, name from STUDENT

    public static final String table = "student";
    public static final String colID = "_id";
    public static final String colName = "name";
    public static final String colAdd = "Address";
    public static final String colBday = "birthday";


    private int id;
    private String name;
    private String add;
    private String bday;

    public Student(String name, String add, String bday) {
        this.name = name;
        this.add = add;
        this.bday = bday;
    }

    public Student() {
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

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }
}
