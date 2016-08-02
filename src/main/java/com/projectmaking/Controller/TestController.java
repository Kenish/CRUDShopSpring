package com.projectmaking.Controller;

import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @Autowired
    UserRepository repository;
    @RequestMapping("/api/test")
    public String printUser(){
        Long id =repository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        return "/api/users/"+id ;
    }
}
