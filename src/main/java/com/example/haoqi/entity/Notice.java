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
    private Integer executorid;

    public Notice(Integer id, Integer courseid, Date date, String content, Integer executorid) {
        this.id = id;
        this.courseid = courseid;
        this.date = date;
        this.content = content;
        this.executorid = executorid;
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
                ", executorid=" + executorid +
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

    public Integer getExecutorid() {
        return executorid;
    }

    public void setExecutorid(Integer executorid) {
        this.executorid = executorid;
    }
}
