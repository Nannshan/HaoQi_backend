package com.example.haoqi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

public class Sign {
    @TableId(type = IdType.AUTO)
    private int id;
    private int courseid;

    @TableField(exist = false)
    private String courseName;
    @TableField(exist = false)
    private String studentName;
    private int studentid;
    private int paid;

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", studentid=" + studentid +
                ", paid=" + paid +
                '}';
    }


    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
