package com.tanzicai.caimusic.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaltController {

    @GetMapping("hello")
    public String sayHello(){
        return "hello";
    }

    public void test(){

    }
}
