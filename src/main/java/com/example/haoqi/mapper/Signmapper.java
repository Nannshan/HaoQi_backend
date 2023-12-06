package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Sign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Signmapper extends BaseMapper<Sign> {
    @Select("select sign.*, course.name as coursename, student.name as studentname from sign, course, student" +
            " where sign.studentid = student.id and sign.courseid = course.id" +
            " and course.name like CONCAT('%', #{courseName}, '%');")
    List<Sign> query(String courseName);

    @Select("select sign.*, course.name as coursename, student.name as studentname from sign, course, student" +
            " where sign.studentid = student.id and sign.courseid = course.id" +
            " and sign.id = #{id}")
    Sign queryDetail(Integer id);


    @Select("select sum(course.price) from sign, course where sign.courseid = course.id and sign.paid = \"1\";")
    Double getTotalMoney();

    @Select("select sign.*, course.name as coursename, student.name as studentname, course.price from sign, course, student" +
            " where sign.studentid = student.id and sign.courseid = course.id and sign.studentid = #{studentId} and sign.courseid = #{courseId}")
    Sign queryById(Integer studentId, Integer courseId);

}

