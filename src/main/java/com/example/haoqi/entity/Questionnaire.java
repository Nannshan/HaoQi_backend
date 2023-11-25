package com.example.haoqi.entity;

public class Questionnaire {
    private int id;
    private int executorid;//执行人id
    private int studentid;//学生id
    private int rating;
    private String coursename;
    private String suggestion;

    @Override
    public String toString() {
        return "questionnaire{" +
                "id=" + id +
                ", executorid=" + executorid +
                ", studentid=" + studentid +
                ", rating=" + rating +
                ", coursename='" + coursename + '\'' +
                ", suggestion='" + suggestion + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExecutorid() {
        return executorid;
    }

    public void setExecutorid(int executorid) {
        this.executorid = executorid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
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

    public Questionnaire(int id, int executorid, int studentid, int rating, String coursename, String suggestion) {
        this.id = id;
        this.executorid = executorid;
        this.studentid = studentid;
        this.rating = rating;
        this.coursename = coursename;
        this.suggestion = suggestion;
    }

}
