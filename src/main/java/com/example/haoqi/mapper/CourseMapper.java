package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    @Insert("insert into course(name,data,position,teacherid,executorid,courseinfo) " +
            "values(#{name},#{data},#{position},#{teacherid},#{executorid},#{courseinfo})")
    public int add(String name , Date date ,String position ,Integer teacherid, Integer executorid, String courseinfo);
}
