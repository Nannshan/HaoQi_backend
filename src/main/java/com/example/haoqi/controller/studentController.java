package com.example.haoqi.controller;

import com.example.haoqi.entity.Student;
import com.example.haoqi.entity.Teacher;
import com.example.haoqi.mapper.StudentMapper;
import com.example.haoqi.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class studentController {
    @Autowired
    private StudentMapper studentMapper;
    @PostMapping("/addstudent")

    public com.example.haoqi.utils.Result addStudent( Student student){
        try{


            studentMapper.insert(student);
            return com.example.haoqi.utils.Result.ok().data("info", "插入成功");
        }catch (DuplicateKeyException e){
            System.out.println(e);
            return  com.example.haoqi.utils.Result.error().data("info", "id号已存在");
        }catch (Exception e){
            System.out.println(e);
            return com.example.haoqi.utils.Result.error().data("info", "参数错误，请重试");
        }
    }
}
