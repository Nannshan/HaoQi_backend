package com.example.haoqi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.haoqi.entity.Application;
import com.example.haoqi.entity.Course;
import com.example.haoqi.mapper.ApplicationMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    private ApplicationMapper applicationMapper;

    //提交申请
    @PostMapping("/submit")
    public Result submitApplication(@RequestBody Application application) {
        try {
            applicationMapper.insert(application);
            return Result.ok().setMessage("提交课程申请成功");
        } catch (Exception e) {
            System.out.println(e);
            return Result.error().setMessage("参数错误");
        }
    }

    //处理申请
    @PostMapping("change")
    public Result agreeApplication(int id, int status) {
        Application application ;
        //根据id拿到对象
        application = applicationMapper.selectById(id);
        if(application.getFlag()!=status){
            application.setFlag(status);
        }else{
            return Result.error().setMessage("无需修改");
        }
        try {
            applicationMapper.updateById(application);
            return Result.ok().setMessage("处理申请成功");
        } catch (Exception e) {
            System.out.println(e);
            return Result.error().setMessage("处理申请错误");
        }
    }

    //查询申请细节
    @GetMapping("/queryDetail")
    public Result queryDetail(Integer id) {
        try {
            Application application = applicationMapper.selectById(id);
            return Result.ok().data(application);
        } catch (Error e) {
            return Result.error().setMessage("查询失败");
        }
    }

    //条件查询
    @GetMapping("/queryPage")
    public Result searchTeacher(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize, String courseName,String companyName) {
        Page<Application> applicationPage = new Page<>(page, pageSize);
        QueryWrapper<Application> queryWrapper = new QueryWrapper();
        if (courseName!=null) {
            queryWrapper.like("coursename", courseName);
        }
        if (companyName!=null) {
            queryWrapper.like("companyname", companyName);
        }
        try {
            applicationMapper.selectPage(applicationPage, queryWrapper);
        } catch (Exception e) {
            System.out.println(e);
        }return Result.ok().data(applicationPage);
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        try {
            int result = applicationMapper.deleteById(id);
            if(result>0){
                return Result.ok().setMessage("删除成功");
            }
            return Result.error().setMessage("删除失败");
        }catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage("删除失败");
        }
    }
}