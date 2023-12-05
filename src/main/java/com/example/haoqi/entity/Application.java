package com.example.haoqi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.annotation.Generated;

@TableName("application")
public class Application {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String coursename;
    private String companyname;
    private String position;
    private Double price;
    private Integer teacherid;
    private Integer flag = 0;

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", coursename='" + coursename + '\'' +
                ", companyname='" + companyname + '\'' +
                ", position='" + position + '\'' +
                ", price=" + price +
                ", teacherid=" + teacherid +
                ", flag=" + flag +
                '}';
    }

    public Application(Integer id, String coursename, String companyname, String position, Double price, Integer teacherid, Integer flag) {
        this.id = id;
        this.coursename = coursename;
        this.companyname = companyname;
        this.position = position;
        this.price = price;
        this.teacherid = teacherid;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
