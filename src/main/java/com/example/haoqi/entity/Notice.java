package com.example.haoqi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class Notice {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer courseid;
    private Date date;
    private String content;

    public Notice(Integer id, Integer courseid, Date date, String content) {
        this.id = id;
        this.courseid = courseid;
        this.date = date;
        this.content = content;
    }

    public Notice() {
    }
    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Notice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
