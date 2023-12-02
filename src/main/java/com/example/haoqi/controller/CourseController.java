package com.example.haoqi.controller;

import com.example.haoqi.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;
}
