package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Questionnaire;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionnaireMapper extends BaseMapper<Questionnaire> {
    @Insert("insert into questionnaire(coursename,studentid,rating,suggestion,executorid) " +
            "values(#{name},#{studentid},#{rating},#{suggestion},#{executorid})")
    public int add( String name ,Integer studentid ,Integer rating, String suggestion,Integer executorid );
}
