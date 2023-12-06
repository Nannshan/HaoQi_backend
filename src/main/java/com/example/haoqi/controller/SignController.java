package com.example.haoqi.controller;

import com.example.haoqi.entity.Sign;
import com.example.haoqi.mapper.Signmapper;
import com.example.haoqi.utils.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/add")
    public Result add(@RequestBody Sign sign){
        System.out.println(sign);
        try{
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
}
