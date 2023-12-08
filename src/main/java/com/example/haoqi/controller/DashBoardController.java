package com.example.haoqi.controller;


import com.example.haoqi.mapper.CourseMapper;
import com.example.haoqi.mapper.Signmapper;
import com.example.haoqi.mapper.StudentMapper;
import com.example.haoqi.mapper.TeacherMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/DashBoard")
public class DashBoardController {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private Signmapper signMapper;

    //课程总数
    public int getCourseNum(){
        return courseMapper.selectCount(null);
    }
    //学生总数
    public int getStudentNum(){
        return studentMapper.selectCount(null);
    }
    //教师总数
    public int getTeacherNum(){
        return teacherMapper.selectCount(null);
    }
    //公司数
    public int getCompanyNum(){
        return studentMapper.getCompanyNum();
    }
    //总培训收入
    public Double getTotalMoney(){
        return signMapper.getTotalMoney();
    }

    @GetMapping("/query")
    public Result getDashBoard(){
        Map dashboard = new HashMap();
        try{
            dashboard.put("CourseNum",getCourseNum());
            dashboard.put("StudentNum",getStudentNum());
            dashboard.put("TeacherNum",getTeacherNum());
            dashboard.put("CompanyNum",getCompanyNum());
            dashboard.put("TotalMoney",getTotalMoney());
            return Result.ok().data(dashboard);
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().data("统计错误");
        }
    }
}
