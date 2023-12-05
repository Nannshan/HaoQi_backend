package com.example.haoqi.controller;

import com.example.haoqi.entity.Student;
import com.example.haoqi.mapper.StudentMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @PostMapping("/add")
    public Result addStudent(@RequestBody  Student student){
        try{
            studentMapper.insert(student);
            return Result.ok().setMessage("插入成功");
        }catch (DuplicateKeyException e){
            System.out.println(e);
            return  Result.error().setMessage( "id号已存在");
        }catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage("参数错误，请重试");
        }
    }
}
