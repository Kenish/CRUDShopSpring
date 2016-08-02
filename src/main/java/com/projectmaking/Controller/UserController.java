package com.projectmaking.Controller;

import com.projectmaking.Model.User;
import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/api/users",method = RequestMethod.GET)
        public User printUser(){
         Long id =repository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
            return repository.findOne(id) ;
        }
    @RequestMapping(value = "/api/users",method = RequestMethod.POST)
    public HttpStatus register(@RequestBody User user){
        repository.saveAndFlush(user);
        return HttpStatus.CREATED;
    }

    @RequestMapping(value = "/api/users",method = RequestMethod.DELETE)
    public HttpStatus DeleteAccount(){
        Long id =repository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
        repository.delete(id);
        return HttpStatus.NO_CONTENT;
    }
    @RequestMapping(value = "/api/users/{id}")
    public HttpStatus forbidden(){
        return HttpStatus.FORBIDDEN;
    }
}
