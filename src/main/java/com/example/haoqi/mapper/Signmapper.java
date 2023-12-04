package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Sign;
import com.example.haoqi.entity.Student;
import com.example.haoqi.entity.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Signmapper{
    @Update("UPDATE sign SET paid=1 WHERE id = #{id}")
    public int updateSign(int id);
    @Select("SELECT * FROM sign")
    List<Sign> select();
}

