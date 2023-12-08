package com.example.haoqi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.haoqi.entity.Questionnaire;
import com.example.haoqi.entity.Sign;
import com.example.haoqi.mapper.QuestionnaireMapper;
import com.example.haoqi.mapper.Signmapper;
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
    @Autowired
    private Signmapper signmapper;

    //添加问卷
    @PostMapping("/add")
    public Result addQuestionnaire(@RequestBody Questionnaire qe){
        try{
            System.out.println(qe);
            questionnaireMapper.insert(qe);
            // 对应的选课记录状态设置为已评价
            Integer studentId = qe.getStudentid();
            Integer courseId = qe.getCourseid();
            Sign sign = signmapper.queryById(studentId, courseId);
            sign.setEvaluated(1);
            signmapper.updateById(sign);
            return Result.ok().setMessage("提交成功");
        }
        catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误，请重试");
        }
    }
    //删除问卷
    @DeleteMapping("/delete")
    public Result deleteTeacher(int id) {
        int rows = questionnaireMapper.deleteById(id);
        if (rows > 0) {
            return Result.ok().setMessage("删除成功");
        } else {
            return Result.error().setMessage("删除失败");
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
