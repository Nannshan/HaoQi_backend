package com.example.haoqi.controller;

import com.example.haoqi.entity.Sign;
import com.example.haoqi.entity.Teacher;
import com.example.haoqi.mapper.Signmapper;
import com.example.haoqi.mapper.TeacherMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class SignController {
    @Autowired
    private Signmapper signmapper;
    @GetMapping("/searchsign")
    public Result searchSign(){

        try {
            List<Sign> signs = signmapper.select();
            return Result.ok().data("signs", signs);
        }catch (Exception e){
            System.out.println(e);
            return Result.error().data("info", "参数错误");
        }
    }
    @PostMapping("/updatesign")
    public int updateTeacher(int id) {
        int rows = signmapper.updateSign(id);
        return rows;
    }
}