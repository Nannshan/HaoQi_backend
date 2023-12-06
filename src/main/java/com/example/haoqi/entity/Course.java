package com.example.haoqi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class Course {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Date date;
    private String position;
    private String courseinfo;
    private Float price;
    private Integer teacherid;

    public Course(Integer id, String name, Date date, String position, String courseinfo, Float price,  Integer teacherid) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.position = position;
        this.courseinfo = courseinfo;
        this.price = price;
        this.teacherid = teacherid;
    }
    public Course () {
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", position='" + position + '\'' +
                ", courseinfo='" + courseinfo + '\'' +
                ", price=" + price +
                ", teacherid=" + teacherid +
                '}';
    }

    public String applicationtoString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", position='" + position + '\'' +
                ", courseinfo='" + courseinfo + '\'' +
                ", price=" + price +
                ", teacherid=" + teacherid +
                '}';
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCourseinfo() {
        return courseinfo;
    }

    public void setCourseinfo(String courseinfo) {
        this.courseinfo = courseinfo;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
