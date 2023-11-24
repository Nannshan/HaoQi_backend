package com.example.haoqi.controller;

import com.example.haoqi.entity.Teacher;
import com.example.haoqi.mapper.TeacherMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;

    @PostMapping("/addTeacher")
    public Result addBook(/*@RequestBody*/ Teacher teacher){
        try{
            // 设置初始的剩余数量(一开始剩余数量等于馆藏数量)

            teacherMapper.insert(teacher);
            return Result.ok().data("info", "插入成功");
        }catch (DuplicateKeyException e){
            System.out.println(e);
            return  Result.error().data("info", "error1");
        }catch (Exception e){
            System.out.println(e);
            return Result.error().data("info", "error2");
        }
    }
}
