package com.example.haoqi.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.haoqi.entity.Teacher;
import com.example.haoqi.mapper.TeacherMapper;
import com.example.haoqi.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;

    @PostMapping("/add")
    public Result addTeacher(@RequestBody Teacher teacher){
        System.out.println(teacher);
        try{
            int result = teacherMapper.insert(teacher);
            if(result>0) return Result.ok().setMessage("插入成功");
            return Result.error().setMessage("插入失败");

        }catch (DuplicateKeyException e){
            System.out.println(e);
            return  Result.error().setMessage( "id号已存在");
        }catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage( "参数错误，请重试");
        }
    }
    @DeleteMapping("/delete")
    public Result deleteTeacher(int id) {
        int rows = teacherMapper.deleteById(id);
        if (rows > 0) {
            return Result.ok().setMessage("删除成功");
        } else {
            return Result.error().setMessage("删除失败");
        }
    }
    @PostMapping("/update")
    public Result updateTeacher(@RequestBody Teacher teacher) {
        int result = teacherMapper.updateById(teacher);
        if(result>0){
            return Result.ok().setMessage("更新成功");
        }else{
            return Result.error().setMessage("插入失败");
        }
    }
    @GetMapping("/query")
    public Result query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize, String name){
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        Page<Teacher> teacherPage = new Page<>(page, pageSize);

        if (name != null) {
            queryWrapper.like("name", name);
            teacherMapper.selectPage(teacherPage, queryWrapper);
        }else{
            teacherMapper.selectPage(teacherPage,null);
        }
        return Result.ok().data(teacherPage);
    }

    @GetMapping("/queryDetail")
    public Result queryDetail(Integer id){
        try{
           return Result.ok().data(teacherMapper.selectById(id));
        }catch (Exception e){
            System.out.println(e);
            return Result.error().setMessage("查询失败");
        }
    }
}
