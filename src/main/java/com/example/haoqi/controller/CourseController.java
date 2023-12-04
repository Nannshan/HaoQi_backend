package com.example.haoqi.controller;

import com.example.haoqi.entity.Course;
import com.example.haoqi.mapper.CourseMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;

    //添加课程,执行人id即为当前登录账号的执行人
    @PostMapping("addCourse")
    public Result addCourse(Course course){
        try{
            courseMapper.add(course.getName(),course.getDate(),course.getPosition(),
                    course.getTeacherid(),1,course.getCourseinfo());
            return Result.ok().data("info","提交申请成功");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().data("info", "参数错误，请重试");
        }
    }
    //更新课程
    //删除课程
    //查找课程
}
