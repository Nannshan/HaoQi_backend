package com.example.haoqi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.models.auth.In;

@TableName("questionnaire")
public class Questionnaire {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer studentid;//学生id
    private Integer courseid;
    private Integer rating;
    @TableField(exist = false)
    private String coursename;
    @TableField(exist = false)
    private String studentname;
    private String suggestion;


    public Questionnaire(Integer id, Integer studentid, Integer courseid, Integer rating, String coursename, String studentname, String suggestion) {
        this.id = id;
        this.studentid = studentid;
        this.courseid = courseid;
        this.rating = rating;
        this.coursename = coursename;
        this.studentname = studentname;
        this.suggestion = suggestion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "id=" + id +
                ", studentid=" + studentid +
                ", courseid=" + courseid +
                ", rating=" + rating +
                ", coursename='" + coursename + '\'' +
                ", studentname='" + studentname + '\'' +
                ", suggestion='" + suggestion + '\'' +
                '}';
    }
}
