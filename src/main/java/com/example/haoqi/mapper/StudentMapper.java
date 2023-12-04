package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Insert("insert into student(name,company,position,phone,email,level,courseid) " +
            "values(#{name},#{company},#{position},#{phone},#{email},#{level},#{courseid});")
    public int add( int courseid,String name,String company,String position,String phone, String email,String level);
}
