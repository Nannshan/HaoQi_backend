package com.example.haoqi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("application")
public class Application {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String phone;
    private String coursename;
    private String companyname;
    private String position;
    private Double price;
    private Integer flag = 0;

    private Integer executorid;

    public Application(Integer id, String phone, String coursename, String companyname, String position, Double price, Integer flag, Integer executorid) {
        this.id = id;
        this.phone = phone;
        this.coursename = coursename;
        this.companyname = companyname;
        this.position = position;
        this.price = price;
        this.flag = flag;
        this.executorid = executorid;
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", coursename='" + coursename + '\'' +
                ", companyname='" + companyname + '\'' +
                ", position='" + position + '\'' +
                ", price=" + price +
                ", flag=" + flag +
                '}';
    }

    public Integer getExecutorid() {
        return executorid;
    }

    public void setExecutorid(Integer executorid) {
        this.executorid = executorid;
    }
}
