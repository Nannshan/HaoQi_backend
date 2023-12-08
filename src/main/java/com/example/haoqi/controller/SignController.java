package com.example.haoqi.controller;

import com.example.haoqi.entity.Course;
import com.example.haoqi.entity.Sign;
import com.example.haoqi.mapper.Signmapper;
import com.example.haoqi.utils.Result;
import io.swagger.models.auth.In;
import org.hamcrest.core.IsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.DoubleStream;

@RestController()
@RequestMapping("/sign")
public class SignController {
    @Autowired
    private Signmapper signMapper;
    @GetMapping("/query")
    public Result query(String courseName){
        List<Sign> result = signMapper.query(courseName);
        return Result.ok().data(result);

    }

    @GetMapping("/queryDetail")
    public Result query(Integer id){
        Sign result = signMapper.queryDetail(id);
        return Result.ok().data(result);
    }
    @GetMapping("/queryById")
    public Result queryById(Integer studentId, Integer courseId){
        Sign result = signMapper.queryById(studentId, courseId);
        if(result !=null){
            return Result.ok().data(result);
        }else{
            return Result.error().setMessage("信息错误");
        }
    }

    @GetMapping("/queryCourse")
    public  Result queryCourse(Integer studentId, Integer status){
        List<Course> result = signMapper.queryCourse(studentId, status);
        return Result.ok().data(result);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Sign sign){
        // 如果有相同的选课记录, 则添加失败
        Sign _sign = signMapper.queryById(sign.getStudentid(),sign.getCourseid());
        if(_sign != null){
            return Result.error().setMessage("以报名, 无需重新报名");
        }
        try{
            // 新增课程评价状态改为未开放评价
            sign.setEvaluated(2);
            signMapper.insert(sign);
            return Result.ok().setMessage("新增成功");
        }catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage("新增失败");
        }
    }

    @PostMapping("/update")
    public Result update(@RequestBody Sign sign){
        try {
        signMapper.updateById(sign);
            return Result.ok().setMessage("更新成功");
        }catch (Exception e){
            return Result.error().setMessage("更新失败");
        }
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id){
        try{
            signMapper.deleteById(id);
            return Result.ok().setMessage("删除成功");
        }catch (Exception e){
            return Result.error().setMessage("删除失败");
        }
    }

    /**
     * 改变课程评价状态
     * @param courseId
     * @param status 2:未开放评价, 0:开放评价但尚未评价
     * @return
     */
    @PutMapping("/changeEvaluateState")
    public Result changeEvaluateState(Integer courseId, Integer status){
        System.out.println(courseId);
        System.out.println(status);
        signMapper.changeEvaluatedState(courseId,status);
        return Result.ok().setMessage("操作成功");
    }
}
