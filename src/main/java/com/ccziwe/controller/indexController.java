package com.ccziwe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    @GetMapping("tran")
    public String tran() {
        return "index";
    }
}
