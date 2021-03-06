package com.lingdu.idea.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestAction {

    @Value("${test:默认值}")
    private String test;

    // 测试地址： http://192.168.116.115:8888/hello?name=lingdu
    @GetMapping("/hello")
    public String sayHello(HttpServletRequest request, HttpServletResponse response) {
        //姓名
        String name = request.getParameter("name");

        //返回状态码
        String status = request.getParameter("status");


        return "Hello World! " + test;
    }

    private void test() {
        System.out.println("test");
    }

}
