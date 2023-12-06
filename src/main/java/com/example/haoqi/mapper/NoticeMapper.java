package com.example.haoqi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haoqi.entity.Notice;
import com.example.haoqi.entity.NoticePlus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {

    @Select("select notice.*, course.name as coursename ,course.position as position ,course.price as price from notice, course where notice.courseid = course.id and notice.id = #{id};")
    NoticePlus query(Integer id);
    @Select("select notice.*, course.name as coursename ,course.position as position ,course.price as price from notice, course where notice.courseid = course.id and course.name like #{courseName};")
    List<NoticePlus> queryPagebyName(String courseName);
    @Select("select notice.*, course.name as coursename ,course.position as position ,course.price as price from notice, course where notice.courseid = course.id;")
    List<NoticePlus> queryPage();
}
