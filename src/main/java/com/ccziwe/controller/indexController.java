package com.ccziwe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/")
    public String hello() {
        return "forward:index.html";
    }

    @GetMapping("tran")
    public String tran() {
        return "forward:conversion.html";
    }
}
