package com.example.haoqi.controller;

import com.example.haoqi.mapper.CourseMapper;
import com.example.haoqi.mapper.NoticeMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeMapper noticeMapper;
    @DeleteMapping("/delete")
    public Result delete(int id){
        try {
            int result = noticeMapper.deleteById(id);
            if(result>0){
                return Result.ok().setMessage("删除成功");
            }
            return Result.error().setMessage("删除失败");
        }catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage("删除失败");
        }
    }

}
