package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Application;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplicationMapper extends BaseMapper<Application> {
    @Insert("insert into application(course,companyname) " +
            "values(#{course},#{companyname})")
    public int add( String course ,String companyname );
}
