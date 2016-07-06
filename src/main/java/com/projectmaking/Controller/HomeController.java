package com.projectmaking.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @RequestMapping("")
    public String home(){
        return "index.html";
    }
    @RequestMapping(value = "register", produces = "text/html;charset=UTF-8")
    public String register(){
        return "register/index.html";
    }
}
