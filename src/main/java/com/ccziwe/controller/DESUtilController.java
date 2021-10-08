package com.ccziwe.controller;

import com.ccziwe.tool.DESUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DESUtilController {
    @RequestMapping(value = "tranURL", method = RequestMethod.POST)
    public String say(@RequestParam("vmess_Url") String url) {
        //System.out.println(url);
        return DESUtil.encrypt("key986800401ccziwe", url);
    }
}
