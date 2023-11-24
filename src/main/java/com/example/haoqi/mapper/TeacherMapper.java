package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Book;
import com.example.haoqi.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Insert("insert into teacher(id,name,title,skills,phone,email) " +
            "values(#{id},#{name},#{title},#{skills},#{phone},#{email})")
    public int add( int id ,String name,String title,String skills,String phone, String email );
    @Delete("DELETE FROM teacher WHERE id = #{id}")
    int deleteById(int id);

    @Update("UPDATE teacher SET name = #{name}, title = #{title}, skills=#{skills},phone = #{phone}, email = #{email} WHERE id = #{id}")
    public int updateTeacher(int id, String name, String title, String skills,String phone, String email);

    @Select("SELECT * FROM teacher")
    List<Teacher> select();

}
