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
            return Result.ok().data("提交申请成功");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().data("参数错误，请重试");
        }
    }

    //同意申请,需要该行的信息的id
    @PostMapping("agreeApplication")
    public Result agreeApplication(Application application){
        application.setFlag(1);
        Course course = application.getCourse();
        CourseController ca = new CourseController();
        try{
            applicationMapper.updateById(application);
            ca.addCourse(course);
            return Result.ok().data("提交申请成功");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().data("参数错误，请重试");
        }
    }

    //拒绝申请
    public Result refuseApplication(Application application){
        application.setFlag(2);
        try{
            applicationMapper.updateById(application);
            return Result.ok().data("拒绝申请成功");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().data("参数错误，请重试");
        }
    }
    //修改申请
}
