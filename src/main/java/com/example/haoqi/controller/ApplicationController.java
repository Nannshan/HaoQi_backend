package com.example.haoqi.controller;

import com.example.haoqi.entity.Application;
import com.example.haoqi.entity.Course;
import com.example.haoqi.mapper.ApplicationMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ApplicationController {
    @Autowired
    private ApplicationMapper applicationMapper;

    //提交申请
    @PostMapping("/submitApplication")
    public Result submitApplication(Application application){
        try{
            applicationMapper.add(application.getCourse().toString(),application.getCompanyname());
            return Result.ok().setMessage( "提交成功");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误");
        }
    }

    //同意申请,需要传入该行的信息
    @PostMapping("agreeApplication")
    public Result agreeApplication(Application application){
        application.setFlag(1);
        Course course = application.getCourse();
        course.setExecutorid(1);
        CourseController ca = new CourseController();
        try{
            applicationMapper.updateById(application);
            //ca.addCourse(course);
            return Result.ok().setMessage( "提交成功");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误");
        }
    }

    //拒绝申请
    @PostMapping("refuseApplication")
    public Result refuseApplication(Application application){
        application.setFlag(2);
        try{
            applicationMapper.updateById(application);
            return Result.ok().setMessage( "拒绝申请成功");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误");
        }
    }
    //修改申请
}
