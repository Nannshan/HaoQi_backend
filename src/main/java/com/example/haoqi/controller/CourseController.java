package com.example.haoqi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.haoqi.entity.Course;
import com.example.haoqi.mapper.CourseMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;

    //添加课程,执行人id即为当前登录账号的执行人
    @PostMapping("/addCourse")
    public Result addCourse(@RequestBody Course course){
        System.out.println(course);
        try{
            int insert = courseMapper.insert(course);
            if(insert>0) return Result.ok().setMessage("新增成功");
            return Result.error().setMessage("新增失败");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().data("参数错误，请重试");
        }
    }
    @GetMapping("/queryPage")
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

    @GetMapping("/queryDetail")
    public Result queryDetail(int id){
        try{
            return Result.ok().data(courseMapper.selectById(id));
        }catch (Error e){
            return Result.error().setMessage("查询失败");
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Course course){
        System.out.println(course);
        try{
            courseMapper.updateById(course);
            return Result.ok().setMessage("更新成功");
        }catch (Error e){
            System.out.println(e);
            return Result.error().setMessage("更新失败");
        }
    }

    @DeleteMapping("/delete")
    public Result delete(int id){
        try {
            int result = courseMapper.deleteById(id);
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
