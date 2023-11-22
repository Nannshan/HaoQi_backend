package com.example.haoqi.Controller.managercontroller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.haoqi.entity.LendRecord;
import com.example.haoqi.entity.Statement;
import com.example.haoqi.entity.User;
import com.example.haoqi.mapper.BookMapper;
import com.example.haoqi.mapper.LendRecordMapper;
import com.example.haoqi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ShowDashBoardController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LendRecordMapper lendRecordMapper;
    @Autowired
    private BookMapper bookMapper;

    //总图书数量
    public int findBookNum(){
        int num = bookMapper.selectCount(null);
        return num;
    }
    //已借阅
    public int findBorrowedNum(){
        QueryWrapper<LendRecord> queryWrapper = new QueryWrapper();
        queryWrapper.eq("status",1).or().eq("status",2);
        int num = lendRecordMapper.selectCount(queryWrapper);
        return num;
    }
    //用户数量
    public int findUserNum(){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("role",0);
        int num = userMapper.selectCount(queryWrapper);
        return num;
    }
    //整合
    @PostMapping("/showDashBoard")
    public Statement showDashBoard(){
        Statement st =new Statement();
        st.setUsernum(findUserNum());
        st.setBooknum(findBookNum());
        st.setBorrowednum(findBorrowedNum());
        System.out.println(st.toString());
        return st;
    }
}
