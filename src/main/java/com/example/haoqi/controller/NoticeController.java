package com.example.haoqi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.haoqi.entity.Application;
import com.example.haoqi.entity.Notice;
import com.example.haoqi.entity.NoticePlus;
import com.example.haoqi.mapper.NoticeMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeMapper noticeMapper;


    //创建通知
    @PostMapping("/submit")
    public Result submitApplication(@RequestBody Notice notice) {
        try {
            noticeMapper.insert(notice);
            return Result.ok().setMessage("创建通知成功");
        } catch (Exception e) {
            System.out.println(e);
            return Result.error().setMessage("参数错误");
        }
    }
    //修改通知
    @PostMapping("/update")
    public Result updateApplication(@RequestBody Notice notice) {
        try {
            noticeMapper.updateById(notice);
            return Result.ok().setMessage("修改成功成功");
        } catch (Exception e) {
            System.out.println(e);
            return Result.error().setMessage("参数错误");
        }
    }

    //查询申请细节
    @GetMapping("/queryDetail")
    public Result queryDetail(Integer id) {
        try {
            //System.out.println(noticeMapper.query(id));
            return Result.ok().data(noticeMapper.query(id));
        } catch (Error e) {
            return Result.error().setMessage("查询失败");
        }
    }

    //条件查询
    @GetMapping("/queryPage")
    public Result searchTeacher(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize, String courseName) {
        System.out.println(courseName);
        Page<NoticePlus> NoticePage = new Page<>(page, pageSize);
        if (!"".equals(courseName)) {
            NoticePage.setRecords(noticeMapper.queryPagebyName(courseName));
        }
        else{
            NoticePage.setRecords(noticeMapper.queryPage());
        }
        try {
            //noticeMapper.selectPage(NoticePage, queryWrapper);
            NoticePage.setTotal(NoticePage.getRecords().size());
            return Result.ok().data(NoticePage);
        } catch (Exception e) {
            System.out.println(e);
            return Result.error().setMessage("查询失败");
        }
    }
    //删除通知
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
