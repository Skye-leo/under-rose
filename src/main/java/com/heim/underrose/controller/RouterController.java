package com.heim.underrose.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {

    @GetMapping("/mass")
    public String massPage(){
        return "chatroom";
    }
}
