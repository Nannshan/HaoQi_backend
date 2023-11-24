package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Insert("insert into book(id,name,title,skills,phone,email) " +
            "values(#{id},#{name},#{title},#{skills},#{phone},#{email})")
    public int add( int id ,String name,String title,String skills,String phone, String email );

}
