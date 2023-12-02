package com.example.haoqi.entity;

public class Application {
    private Course course;
    private String companyname;

    public Application(Course course, String companyname) {
        this.course = course;
        this.companyname = companyname;
    }

    @Override
    public String toString() {
        return "Application{" +
                course.toString() +
                ", companyname='" + companyname + '\'' +
                '}';
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
