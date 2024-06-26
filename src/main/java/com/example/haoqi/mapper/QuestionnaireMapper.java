package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Questionnaire;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionnaireMapper extends BaseMapper<Questionnaire> {
    @Select("select questionnaire.* , course.name as coursename, student.name as studentname from questionnaire, course, student " +
            "where questionnaire.courseid = course.id and questionnaire.studentid = student.id and course.name like CONCAT('%', #{courseName}, '%');")
    List<Questionnaire> query(String courseName);

    @Select("select questionnaire.* , course.name as coursenagitme, student.name as studentname from questionnaire, course, student " +
            "where questionnaire.courseid = course.id and questionnaire.studentid = student.id and sign.id = #{id};")
    List<Questionnaire> queryDetail(Integer id);

}
