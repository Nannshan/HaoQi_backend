package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Executor;
import com.example.haoqi.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ExecutorMapper extends BaseMapper<Executor> {
    @Select("select password from executor where id =#{id}")
    public String getPassword(int id);
}
