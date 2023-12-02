package com.example.haoqi.controller;

import com.example.haoqi.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ApplicationController {
    @Autowired
    private ApplicationMapper applicationMapper;
}
