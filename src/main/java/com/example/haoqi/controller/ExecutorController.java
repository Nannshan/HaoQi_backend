package com.example.haoqi.controller;

import com.example.haoqi.mapper.ExecutorMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/executor")
public class ExecutorController {
    @Autowired
    private ExecutorMapper executorMapper;

    @PostMapping("/login")
    public Result login(int id, String password) {

        String psd= executorMapper.getPassword(id);
        if(psd!=null) {
            if (psd.equals(password) ) {
                return Result.ok().data(executorMapper.selectById(id));
            } else {

                return Result.ok().setMessage("密码错误");
            }

        }else{
            return Result.error().setMessage("id不存在");
        }
    }

}
