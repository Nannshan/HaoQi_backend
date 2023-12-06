package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Questionnaire;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionnaireMapper extends BaseMapper<Questionnaire> {
<<<<<<< HEAD
    @Select("select questionnaire.* , course.name as coursename, student.name as studentname from questionnaire, course, student " +
            "where questionnaire.courseid = course.id and questionnaire.studentid = student.id and course.name like CONCAT('%', #{courseName}, '%');")
    List<Questionnaire> query(String courseName);

    @Select("select questionnaire.* , course.name as coursename, student.name as studentname from questionnaire, course, student " +
            "where questionnaire.courseid = course.id and questionnaire.studentid = student.id and sign.id = #{id};")
    List<Questionnaire> queryDetail(Integer id);


=======
>>>>>>> 3afa36de68a3df8fdb3eb1460c5ead88d6bc8fbf
}
