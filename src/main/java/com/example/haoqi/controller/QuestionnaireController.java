package com.example.haoqi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.haoqi.entity.Questionnaire;
import com.example.haoqi.mapper.QuestionnaireMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/questionnaire")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    //添加问卷
    @PostMapping("/add")
    public Result addQuestionnaire(@RequestBody Questionnaire qe){
        try{
            questionnaireMapper.insert(qe);
            return Result.ok().setMessage("提交成功");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误，请重试");
        }
    }
    //删除问卷
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTeacher(int id) {
        int rows = questionnaireMapper.deleteById(id);
        if (rows > 0) {
            return ResponseEntity.ok("删除成功");
        } else {
            return ResponseEntity.ok("删除失败");
        }
    }

    /*
    * 查询问卷
    *  条件：
    *  课程名
    */
    @GetMapping("/query")
    public Result query(String courseName){
        try {
            List<Questionnaire> questionnaires = questionnaireMapper.query(courseName);
            return Result.ok().data(questionnaires);
        }catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误");
        }
    }

    @GetMapping("/queryDetail")
    public Result queryDetail(Integer id){
        try {
            List<Questionnaire> questionnaires = questionnaireMapper.queryDetail(id);
            return Result.ok().data(questionnaires);
        }catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误");
        }
    }


}
