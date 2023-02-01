package com.xrq.springsecurity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class Controller {

    @RequestMapping("/a")
    public String a(HttpServletRequest request){


        HttpSession session = request.getSession();

        System.out.println("session.getAttribute before:"+session.getAttribute("keyXrq"));
        session.setAttribute("keyXrq","12345xrq");
        System.out.println("session.getAttribute after:"+session.getAttribute("keyXrq"));


        return "a";
    }


}
