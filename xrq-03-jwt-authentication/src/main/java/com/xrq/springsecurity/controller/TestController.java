package com.xrq.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/a")
    public String a(){
        return "a";
    }

    @RequestMapping("/b")
    public String b(){
        return "b";
    }

    @RequestMapping("/c")
    public String c(){
        return "c";
    }

    @RequestMapping("/d")
    public String d(){
        int i=1/0;
        return "d";
    }

}
