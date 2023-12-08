package com.example.haoqi.entity;

import java.util.Date;

public class NoticePlus extends Notice{
    private String coursename;
    private String position;
    private Double price;

    @Override
    public String toString() {
        return "NoticePlus{" +
                "coursename='" + coursename + '\'' +
                ", position='" + position + '\'' +
                ", price=" + price +
                '}';
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
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

    public NoticePlus(Integer id, Integer courseid, Date date, String content, Integer executorid, String coursename, String position, Double price) {
        super(id, courseid, date, content, executorid);
        this.coursename = coursename;
        this.position = position;
        this.price = price;
    }

    public NoticePlus(String coursename, String position, Double price) {
        this.coursename = coursename;
        this.position = position;
        this.price = price;
    }

    public NoticePlus(Integer id, String coursename, String position, Double price) {
        super(id);
        this.coursename = coursename;
        this.position = position;
        this.price = price;
    }
}
