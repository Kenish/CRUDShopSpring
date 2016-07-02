package com.projectmaking.Controller;

import com.projectmaking.Model.User;
import com.projectmaking.Repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
    UserRepository repository;
    @Autowired
    public UserController(UserRepository repository){
       this.repository=repository ;
    }


    @RequestMapping(value = "users",method = RequestMethod.GET)
    public List<User> list(){
        return repository.findAll();
    }

    @RequestMapping(value = "users/{id}",method = RequestMethod.GET)
    public User get(@PathVariable Long id){
       return repository.findOne(id);
    }

    @RequestMapping(value = "users/{id}",method = RequestMethod.POST)
    public User add(@RequestBody User user){
        return repository.save(user);
    }

    @RequestMapping(value = "users/{id}",method = RequestMethod.DELETE)
    public void delete(@RequestBody User user){
        repository.delete(user);
    }

    @RequestMapping(value = "users/{id}",method = RequestMethod.PUT)
    public void update(@RequestBody User user, @RequestParam Long id){
        User olduser=repository.findOne(id);
        BeanUtils.copyProperties(user,olduser);
        repository.saveAndFlush(olduser);
    }

}
