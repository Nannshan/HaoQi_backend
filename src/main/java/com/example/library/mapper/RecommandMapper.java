package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Recommend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecommandMapper extends BaseMapper<Recommend> {
    @Insert("insert into recommand(uid,recname,reauthor,republisher,email,reason) " +
            "values(#{uid},#{recname},#{reauthor},#{republisher},#{email},#{reason})")
    public int add(Integer uid,String recname,String reauthor,String republisher,String email ,String reason);
}
