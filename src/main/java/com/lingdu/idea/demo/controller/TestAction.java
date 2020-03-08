package com.lingdu.idea.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestAction {

    @GetMapping("/hello")
    public String sayHello(HttpServletRequest request, HttpServletResponse response) {
        //姓名
        String name = request.getParameter("name");

        //返回状态码
        String status = request.getParameter("status");


        return "Hello World!";
    }

}
