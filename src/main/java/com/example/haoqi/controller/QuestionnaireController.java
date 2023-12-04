package com.example.haoqi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.haoqi.entity.Questionnaire;
import com.example.haoqi.mapper.QuestionnaireMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class QuestionnaireController {
    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    //添加课后调查
    @PostMapping("/addQuestionnaire")
    public Result addQuestionnaire(Questionnaire qe){
        try{
            questionnaireMapper.insert(qe);
            return Result.ok().setMessage("提交成功");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误，请重试");
        }
    }
    //删除课后调查
    @DeleteMapping("/deleteQuestionnaire")
    public ResponseEntity<String> deleteTeacher(int id) {
        int rows = questionnaireMapper.deleteById(id);
        if (rows > 0) {
            return ResponseEntity.ok("删除成功");
        } else {
            return ResponseEntity.ok("删除失败");
        }
    }

    /*
    * TODO：查询课后调查
    *  条件：
    *  执行人id
    *  学生id
    *  课程名
    */
    @GetMapping("/searchQuestionnaire")
    public Result searchTeacher(Questionnaire questionnaire){
        QueryWrapper<Questionnaire> queryWrapper = new QueryWrapper();
        queryWrapper.like("executorid",questionnaire.getExecutorid());
        queryWrapper.like("studentid",questionnaire.getStudentid());
        queryWrapper.like("coursename",questionnaire.getCoursename());

        try {
            List<Questionnaire> questionnaires = questionnaireMapper.selectList(queryWrapper);
            //System.out.println("fdfsfs");
            //System.out.println(questionnaires.isEmpty());
            return Result.ok().data(questionnaires);
        }catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误");
        }
    }

}
