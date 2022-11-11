package com.xrq.springsecurity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
