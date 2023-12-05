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

    //添加问卷
    @PostMapping("/addQuestionnaire")
    public Result addQuestionnaire(Questionnaire qe,Integer usesrid){
        try{
            questionnaireMapper.add(qe.getCoursename(),usesrid,qe.getRating(),qe.getSuggestion(),1);
            return Result.ok().setMessage("提交成功");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误，请重试");
        }
    }
    //删除问卷
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
    * 查询问卷
    *  条件：
    *  课程名
    */
    @GetMapping("/searchQuestionnaire")
    public Result searchTeacher(String coursename){
        coursename = ""; //无条件查询所有课程
        QueryWrapper<Questionnaire> queryWrapper = new QueryWrapper();
        if(!coursename.equals("")){
        queryWrapper.like("coursename",coursename);}

        try {
            List<Questionnaire> questionnaires = questionnaireMapper.selectList(queryWrapper);
            return Result.ok().data(questionnaires);
        }catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误");
        }
    }

}
