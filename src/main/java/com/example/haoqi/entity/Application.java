package com.example.haoqi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.bytebuddy.dynamic.DynamicType;

@TableName("application")
public class Application {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Course course;
    private String companyname;
    private Integer flag = 0;

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", course=" + course.toString() +
                ", companyname='" + companyname + '\'' +
                '}';
    }

    public Application(Integer id, Course course, String companyname) {
        this.id = id;
        this.course = course;
        this.companyname = companyname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
