package com.hackathon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by XiaowenZeng on 16/11/23.
 */

@Controller
public class SysController {
    @RequestMapping("/login")
    public String  login(){
        return "index";

    }
}
