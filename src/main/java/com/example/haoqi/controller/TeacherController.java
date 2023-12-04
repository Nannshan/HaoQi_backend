package com.example.haoqi.controller;
import com.example.haoqi.entity.Teacher;
import com.example.haoqi.mapper.TeacherMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;

    @PostMapping("/addTeacher")
    public Result addTeacher(/*@RequestBody*/ Teacher teacher){
        try{
            teacherMapper.add(teacher.getName(),teacher.getTitle(),teacher.getSkills(),teacher.getPhone(),teacher.getEmail());
            return Result.ok().data("info", "插入成功");
        }catch (DuplicateKeyException e){
            System.out.println(e);
            return  Result.error().data("info", "id号已存在");
        }catch (Exception e){
            System.out.println(e);
            return Result.error().data("info", "参数错误，请重试");
        }
    }
    @DeleteMapping("/deleteTeacher")
    public ResponseEntity<String> deleteTeacher(int id) {
        int rows = teacherMapper.deleteById(id);
        if (rows > 0) {
            return ResponseEntity.ok("删除成功");
        } else {
            return ResponseEntity.ok("删除失败");
        }
    }
    @PostMapping("/updateTeacher")
    public int updateTeacher(int id, String name, String title, String skills,String phone, String email) {
        int rows = teacherMapper.updateTeacher(id,name,title,skills,phone,email);
        return rows;
    }
    @GetMapping("/searchTeacher")
    public Result searchTeacher(){

        try {
            List<Teacher> teachers = teacherMapper.select();
            return Result.ok().data("teachers", teachers);
        }catch (Exception e){
            System.out.println(e);
            return Result.error().data("info", "参数错误");
        }
    }

}
