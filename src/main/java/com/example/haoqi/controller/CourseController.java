package com.example.haoqi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.haoqi.entity.Course;
import com.example.haoqi.mapper.CourseMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;

    //添加课程,执行人id即为当前登录账号的执行人
    //更新课程
    //删除课程
    //查找课程
    @PostMapping("/queryPage")
    public Result queryPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize, String courseName) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        Page<Course> coursePage = new Page<>(page, pageSize);

        if (courseName != null) {
            queryWrapper.like("name", courseName);
            courseMapper.selectPage(coursePage, queryWrapper);

        }
        courseMapper.selectPage(coursePage, queryWrapper);
        return Result.ok().data(coursePage);
    }
}
