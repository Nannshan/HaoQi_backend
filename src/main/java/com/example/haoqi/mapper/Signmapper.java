package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Sign;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Signmapper extends BaseMapper<Sign> {
    @Update("UPDATE sign SET paid=1 WHERE id = #{id}")
    public int updateSign(int id);
    @Select("SELECT * FROM sign")
    List<Sign> select();

    @Select("select sign.*, course.name as coursename, student.name as studentname from sign, course, student where sign.studentid = student.id and sign.courseid = course.id;")
    List<Sign> query();
}

