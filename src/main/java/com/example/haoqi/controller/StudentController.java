package com.example.haoqi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.haoqi.entity.Student;
import com.example.haoqi.entity.Teacher;
import com.example.haoqi.mapper.StudentMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @PostMapping("/add")
    public Result addStudent(@RequestBody  Student student){
        try{
            studentMapper.insert(student);
            return Result.ok().setMessage("插入成功");
        }catch (DuplicateKeyException e){
            System.out.println(e);
            return  Result.error().setMessage( "id号已存在");
        }catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage("参数错误，请重试");
        }
    }
    @DeleteMapping("/delete")
    public Result deleteStudent(int id) {
        int rows = studentMapper.deleteById(id);
        if (rows > 0) {
            return Result.ok().setMessage("删除成功");
        } else {
            return Result.error().setMessage("删除失败");
        }
    }
    @PostMapping("/update")
    public Result updateStudent(@RequestBody Student student) {
        int result = studentMapper.updateById(student);
        if(result>0){
            return Result.ok().setMessage("更新成功");
        }else{
            return Result.error().setMessage("更新失败");
        }
    }
    @GetMapping("/query")
    public Result query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize, String name){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        Page<Student> studentPage = new Page<>(page, pageSize);

        if (name != null) {
            queryWrapper.like("name", name);
            studentMapper.selectPage(studentPage, queryWrapper);
        }else{
           studentMapper.selectPage(studentPage,null);
        }
        return Result.ok().data(studentPage);
    }
    @PostMapping("/login")
    public Result login(int id,String password) {

         String psd=studentMapper.getPassword(id);
        if(psd!=null) {
             if (psd.equals(password) ) {
                 return Result.ok().data(studentMapper.selectById(id));
             } else {

                 return Result.ok().setMessage("密码错误");
             }

         }else{
            return Result.error().setMessage("id不存在");
        }
    }






}
