package com.projectmaking.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HomeController {
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return "/registerPage.html";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(){
        return "/welcomePage.html";
    }

}
