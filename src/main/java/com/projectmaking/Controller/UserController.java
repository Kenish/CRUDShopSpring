package com.projectmaking.Controller;

import com.projectmaking.Model.User;
import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
    private UserRepository repository;
    @Autowired
    public UserController(UserRepository repository){
       this.repository = repository ;
    }


    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> list(){
      return repository.findAll();
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id){
       return repository.findOne(id);
    }

    @RequestMapping(value = "users", method = RequestMethod.POST)
    public User add(@RequestBody User user){
       return repository.saveAndFlush(user);
    }

/*    @RequestMapping(value = "users", method = RequestMethod.POST)
    public String success(){
        return "SUCCESS";
    }*/


    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        repository.delete(id);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody User user, @PathVariable Long id){
        User oldUser = repository.findOne(id);
        BeanUtils.copyProperties(user,oldUser);
        repository.saveAndFlush(oldUser);
    }

}
