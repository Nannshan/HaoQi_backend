package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Course;
import com.example.haoqi.entity.Sign;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select("select course.*, teacher.name as teacherName from sign, course, student, teacher where sign.studentid = student.id and sign.courseid = course.id and teacher.id = course.teacherid " +
            "and sign.evaluated = #{status} and sign.studentid = #{studentId}")
    List<Course> queryCourse(Integer studentId, Integer status);


    @Select("select sum(course.price) from sign, course where sign.courseid = course.id and sign.paid = \"1\";")
    Double getTotalMoney();



    @Select("select sign.*, course.name as coursename, student.name as studentname, course.price from sign, course, student" +
            " where sign.studentid = student.id and sign.courseid = course.id and sign.studentid = #{studentId} and sign.courseid = #{courseId}")
    Sign queryById(Integer studentId, Integer courseId);

    @Update("UPDATE sign " +
            "SET evaluated = #{status} " +
            "WHERE courseid = #{courseId};")
    void changeEvaluatedState(Integer courseId, Integer status);
}

