package com.projectmaking.Controller;

import com.projectmaking.Model.User;
import com.projectmaking.Repository.UserRepository;
import com.projectmaking.Service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserManagementService userManagementService;

    @RequestMapping(value = "/api/users",method = RequestMethod.GET)
    public User printUser(){
        return userManagementService.printUser();
        }

    @RequestMapping(value = "/api/users",method = RequestMethod.POST)
    public HttpStatus register(@RequestBody User user){
        return  userManagementService.register(user);
    }

    @RequestMapping(value = "/api/users",method = RequestMethod.DELETE)
    public HttpStatus DeleteAccount(){
        return userManagementService.deleteAccount();
    }

    @RequestMapping(value = "/api/users/{id}")
    public HttpStatus forbidden(){
        return HttpStatus.FORBIDDEN;
    }
}
